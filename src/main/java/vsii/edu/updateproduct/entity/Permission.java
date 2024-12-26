package vsii.edu.updateproduct.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;

   // @Enumerated(EnumType.STRING)
    @Column(name = "http_method")
        private String urlPattern;
    }



