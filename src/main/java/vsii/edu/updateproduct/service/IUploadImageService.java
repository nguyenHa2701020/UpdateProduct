package vsii.edu.updateproduct.service;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import vsii.edu.updateproduct.dto.ThietBiImageDto;
import vsii.edu.updateproduct.entity.ThietBiImage;
import vsii.edu.updateproduct.exception.DataNotFoundException;

import java.io.IOException;
import java.util.Map;

public interface IUploadImageService {
    /**
     * phuong thuc nay de lay ra video url theo courseId
     * @param courseId
     * @return tra ve url cua video khoa hoc theo courseId tuong ung
     * @throws Exception nem ra ex chua ro rang khi loi lay video tu cloudinary (sai {@link CloudinaryConfig} CLOUD_NAME, API_SECRET, API_KEY)
     */
   // String getByThietBiId(Long thietBiId) throws Exception;

//    String getByThietBiId(Long id) throws Exception;
}
