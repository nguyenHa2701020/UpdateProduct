package vsii.edu.updateproduct.config;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
////import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
////import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import io.swagger.v3.oas.models.servers.Server;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

/**
 * Class nay duoc danh dau la Configuration cau hinh swagger (them phu thuoc trong pom.xml)
 * chua cac cloud_name: ma cua nguoi dung tren cloudinary
 * api_key
 * api_secret: hai api nay de xac minh quyen truy cap vao cloudinary nguoi dung
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi publicApi(@Value("${openapi.service.api-docs}") String apiDocs) {
        return GroupedOpenApi.builder()
                .group(apiDocs) // /v3/api-docs/api-service
                .packagesToScan("vsii.edu.updateproduct.controller")
                .build();
    }

    // method de thiet lap cac thanh phan cho trang swagger
    @Bean
    public OpenAPI openAPI(
            @Value("${openapi.service.title}") String title,
            @Value("${openapi.service.version}") String version,
            @Value("${openapi.service.server}") String serverUrl) {
        return new OpenAPI()
                .servers(List.of(new Server().url(serverUrl)))
                .info(new Info().title(title)
                        .description("API documents")
                        .version(version)
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .addSecurityItem(new SecurityRequirement().addList("Bearer Token"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Token", new SecurityScheme()
                                .name("Authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))); // config Bearer Token
    }

//    @OpenAPIDefinition(
////            info = @Info(
////                    contact = @Contact(
////                            name = "Alibou",
////                            email = "contact@aliboucoding.com",
////                            url = "https://aliboucoding.com/course"
////                    ),
//            info = @Info(
//                    description = "OpenApi documentation for Spring Security",
//                    title = "OpenApi specification - Alibou",
//                    version = "1.0",
//                    license = @License(
//                            name = "Licence name",
//                            url = "https://some-url.com"
//                    ),
//                    termsOfService = "Terms of service"
//            ),
//            servers = {
//                    @Server(
//                            description = "Local ENV",
//                            url = "http://localhost:8080"
//                    ),
////                    @Server(
////                            description = "PROD ENV",
////                            url = "https://aliboucoding.com/product"
////                    )
//            },
//            security = {
//                    @SecurityRequirement(
//                            name = "bearerAuth"
//                    )
//            }
//    )
//    @SecurityScheme(
//            name = "bearerAuth",
//            description = "JWT auth description",
//            scheme = "bearer",
//            type = SecuritySchemeType.HTTP,
//            bearerFormat = "JWT",
//            in = SecuritySchemeIn.HEADER
//    )
//    public class OpenAPIConfig {
}
