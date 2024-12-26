package vsii.edu.updateproduct.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import static vsii.edu.updateproduct.util.Permission.ADMIN_READ;
//import static vsii.edu.updateproduct.util.Permission.ADMIN_UPDATE;
//import static vsii.edu.updateproduct.util.Permission.MANAGER_UPDATE;

//@RequiredArgsConstructor
@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permission = new HashSet<>();


}
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        @Column(nullable = false, unique = true)
//        private String name;
//
//        @ManyToMany(fetch = FetchType.EAGER)
//        @JoinTable(
//                name = "role_permissions",
//                joinColumns = @JoinColumn(name = "role_id"),
//                inverseJoinColumns = @JoinColumn(name = "permission_id")
//        )
//        private Set<Permission> permissions = new HashSet<>();
//
//        public List<SimpleGrantedAuthority> getAuthorities() {
//            var authorities = permissions.stream()
//                    .map(permission -> new SimpleGrantedAuthority(permission.getUrlPattern()))
//                    .collect(Collectors.toList());
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name.toUpperCase()));
//            return authorities;
//        }
   // }

//    USER(Collections.emptySet()),
//    ADMIN(
//            Set.of(
//                    ADMIN_READ,
//                    ADMIN_UPDATE
//
//            )
//    ),
//    MANAGER(
//            Set.of(
//                    MANAGER_READ,
//                    MANAGER_UPDATE
//            )
//    );
//
//    @Getter
//    private final Set<Permission> permissions;
//
//    public List<SimpleGrantedAuthority> getAuthorities() {
//        var authorities = getPermissions()
//                .stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getUrlPattern()))
//                .collect(Collectors.toList());
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return authorities;
//    }





