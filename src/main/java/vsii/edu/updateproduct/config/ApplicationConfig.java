package vsii.edu.updateproduct.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import vsii.edu.updateproduct.repository.UserRepository;
//import vsii.edu.updateproduct.security.auditing.ApplicationAuditAware;

@Configuration
//@RequiredArgsConstructor
public class ApplicationConfig {
    /**
     * cau hinh CORS cho phep cac yeu cau duoc viec cho phep truy cap tren cac localhost de tuong tac
     * @return tra ve kieu Bean de cau hinh cho CORS
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter());
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
//    private final UserRepository repository;
//
//    /**
//     * @return đối tượng UserDetails chứa thông tin về người dùng,
//     * bao gồm tên đăng nhập, mật khẩu đã mã hóa, và các quyền (authorities).
//     * Tìm người dùng dựa trên email, trả về thông tin người dùng để xác thực
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> repository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//
//    /**
//     * Cung cấp cơ chế xác thực dựa trên UserDetailsService và bộ mã hóa mật khẩu.
//     * Sử dụng userDetailsService đã định nghĩa ở trên để tìm người dùng và kiểm tra thông tin đăng nhập.
//     * Sử dụng BCryptPasswordEncoder để kiểm tra mật khẩu khi xác thực.
//     * @return
//     */
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    /**
//     * Phương thức này trả về thông tin về người dùng hiện tại (ID), được dùng để tự động gán giá trị cho các trường @CreatedBy và @LastModifiedBy trong các thực thể.
//     * @return
//     */
//    @Bean
//    public AuditorAware<Long> auditorAware() {
//        return new ApplicationAuditAware();
//    }
////xử lý xác thực trong Spring Security
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
////Cung cấp một PasswordEncoder để mã hóa mật khẩu.
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
