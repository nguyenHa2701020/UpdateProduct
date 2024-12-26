package vsii.edu.updateproduct.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import vsii.edu.updateproduct.util.ConstantKey;

/**
 * duoc danh dau la lop cau hinh
 * dung de config cac file upload khong vuot qua 100MB
 */
@Configuration

public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        factory.setMaxFileSize(DataSize.ofMegabytes(ConstantKey.MAX_FILE_SIZE_MB));
        factory.setMaxRequestSize(DataSize.ofMegabytes(ConstantKey.MAX_FILE_SIZE_MB));

        return factory.createMultipartConfig();
    }


}
