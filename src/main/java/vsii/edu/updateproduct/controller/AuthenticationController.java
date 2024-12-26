package vsii.edu.updateproduct.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vsii.edu.updateproduct.dto.LoginRequestDto;
import vsii.edu.updateproduct.dto.RegisterRequestDTO;
import vsii.edu.updateproduct.dto.response.JwtResponse;
//import vsii.edu.updateproduct.dto.response.MessageResponse;
import vsii.edu.updateproduct.dto.response.MessageSuccess;
import vsii.edu.updateproduct.entity.Role;
import vsii.edu.updateproduct.entity.User;
import vsii.edu.updateproduct.repository.RoleRepository;
import vsii.edu.updateproduct.repository.UserRepository;
import vsii.edu.updateproduct.security.JwtUtils;
import vsii.edu.updateproduct.security.UserDetailsImpl;
//import vsii.edu.updateproduct.dto.response.UserResponse;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
    @RequestMapping("/api/v1/auth")
    @RequiredArgsConstructor
    public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        if (userRepository.existsByUsername(registerRequestDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageSuccess("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageSuccess("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(registerRequestDTO.getUsername(),
                registerRequestDTO.getEmail(),
                encoder.encode(registerRequestDTO.getPassword()));

        Set<String> strRoles = registerRequestDTO.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName("ADMIN")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
                    default:
                        Role userRole = roleRepository.findByName("MANAGENT")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageSuccess("User registered successfully!"));
    }
//        private final AuthenticationService service;
//
//        @PostMapping("/register")
//        public ResponseEntity<AuthenticationResponse> register(
//                @RequestBody @Valid RegisterRequest request
//        ) {
//            return ResponseEntity.ok(service.register(request));
//        }
//        @PostMapping("/authenticate")
//        public ResponseEntity<UserResponse> authenticate(
//                @RequestBody AuthenticationRequest request
//        ) {
//            return ResponseEntity.ok(service.authenticate(request));
//        }

//        @PostMapping("/refresh-token")
//        public void refreshToken(
//                HttpServletRequest request,
//                HttpServletResponse response
//        ) throws IOException {
//            service.refreshToken(request, response);
//        }
}
