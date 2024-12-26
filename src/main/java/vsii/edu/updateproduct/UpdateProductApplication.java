package vsii.edu.updateproduct;

import com.cloudinary.Cloudinary;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@OpenAPIDefinition(
//        info = @Info(
//                title = "Update Product REST API Documentation",
//                description = "Update Product REST API Documentation",
//                version = "v1",
////                contact = @Contact(
////                            name = "Nguyen Ha"
////                        email = "nguyenthiha270102@gmail.com",
////                        url = "https://www.facebook.com/?locale=vi_VN"
////                ),
//                license = @License(
//                        name = "Apache 2.0"
//                        //  url = "https://www.facebook.com/?locale=vi_VN"
//                )
//        ),
//        externalDocs = @ExternalDocumentation(
//                description = "Update Product REST API Documentation"
//                //  url = "https://www.facebook.com/?locale=vi_VN"
//        )
//)
public class UpdateProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdateProductApplication.class, args);
    }


}
