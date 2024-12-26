package vsii.edu.updateproduct.repository;

import com.cloudinary.provisioning.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.User;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

//    @Query("UPDATE User a SET a.password = :password WHERE a.id = :userId")
//    int updatePassword(@Param("password") String password, @Param("userId") Long userId);
  //  Optional<User> findByEmail(String email);
//    Boolean existsByPhoneNumber(String phoneNumber);
//    Optional<Account> findByPhoneNumber(String phoneNumber);
//
//    @Query("UPDATE Account a SET a.password = :password WHERE a.id = :accountId")
//    int updatePassword(@Param("password") String password, @Param("accountId") Long accountId);


}
