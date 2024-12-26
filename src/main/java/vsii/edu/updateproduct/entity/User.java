package vsii.edu.updateproduct.entity;


import jakarta.persistence.*;

import java.util.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import vsii.edu.updateproduct.security.token.Token;


@AllArgsConstructor

@Getter
@Setter
@Entity
@Builder
@Data

@Table(name = "_user")
public class User   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 10, unique = true)
    private String username;



    //    @Email
    @Column(name = "email")
//    @Convert(converter = AESEncryptionConfig.class)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;

//    @Column(name = "active")
//    private boolean active;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(  name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();
    public User() {
    }

    // Constructor với các trường cần thiết
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.getRole().getName().toUpperCase()));
//
//        this.getRole().getPermissions().forEach(permission ->
//                authorities.add(new SimpleGrantedAuthority(permission.getName()))
//        );
//
//        return authorities;
//    }

//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }










    //    @Override
//    public String getUsername() {
//        return phoneNumber;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
}
