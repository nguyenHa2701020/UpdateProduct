package vsii.edu.updateproduct.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service
public interface IPermissionService {
    //    public List<Permission> getAllPermissions();
    public Map<String, Map<String, Set<String>>> loadPermissions();
}
