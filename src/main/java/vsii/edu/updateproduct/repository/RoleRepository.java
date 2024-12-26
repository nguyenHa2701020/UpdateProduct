package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vsii.edu.updateproduct.entity.Role;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long>
{   Optional<Role> findByName(String name);
}
