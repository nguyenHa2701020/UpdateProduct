package vsii.edu.updateproduct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequestDTO {

    @NotBlank(message = "User name is required")
    @Size(min = 3, max = 20, message = "User name must be exactly 10 digits")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank(message = "Password can't blank")
    @Size(min = 6, max = 255,  message = "Password must be between 6 and 255 characters")
    private String password;
//    @NotBlank(message = "Phone number is required")
//    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
//    @Pattern(regexp = "0\\d{9}", message = "Phone number must start with 0 and contain 10 digits")
//    private String phoneNumber;
//
//    @NotBlank(message = "Email is required")
////    @Size(min = 11, max = 255, message = "Username must be between 11 and 255 characters")
//    @Email
//    private String email;
//
//    @NotBlank(message = "Password can't blank")
//    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
//    private String password;
//
//    @JsonProperty("retype_password")
//    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
//    private String retypePassword;
//
//    @JsonProperty("role_id")
//    @Min(value = 0, message = "Role Id must be positive integer")
//    private Long roleId;
}
