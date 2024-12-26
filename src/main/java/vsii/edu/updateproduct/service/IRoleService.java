package vsii.edu.updateproduct.service;

import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.entity.Role;

@Service
public interface IRoleService {
    public Role getRoleWithPermissions(String roleName);

}
