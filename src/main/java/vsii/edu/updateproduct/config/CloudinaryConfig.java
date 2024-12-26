package vsii.edu.updateproduct.config;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class nay duoc danh dau la Configuration dung de cau hinh cloudinary (them phu thuoc trong pom.xml)
 * chua cac cloud_name: ma cua nguoi dung tren cloudinary
 *          api_key
 *          api_secret: hai api nay de xac minh quyen truy cap vao cloudinary nguoi dung
 */
@Configuration
public class CloudinaryConfig {
    private final String CLOUD_NAME = "dcwdxbe2l";
    private final String API_KEY = "878478983637188";
    private final String API_SECRET = "MdykQHSox3Kv06gXQWtfXkCr32c";

    /**
     * truyen vao cac thong tin de co the truy cap vao cloudinary
     * @return
     */
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name",CLOUD_NAME,
                "api_key",API_KEY,
                "api_secret",API_SECRET,
                "secure", true

        ));
        return cloudinary;
    }

}
