package vsii.edu.updateproduct.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.entity.Role;
import vsii.edu.updateproduct.repository.RoleRepository;
import vsii.edu.updateproduct.service.IRoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl  implements IRoleService {
    private final RoleRepository roleRepository;

    public Role getRoleWithPermissions(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
    }
}
