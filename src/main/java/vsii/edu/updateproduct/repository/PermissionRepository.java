package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.Permission;
import vsii.edu.updateproduct.entity.Role;

import java.util.Optional;

@Repository
public interface PermissionRepository  extends JpaRepository<Permission, Long>  {
        Optional<Role> findByName(String name);
}
