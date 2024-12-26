package vsii.edu.updateproduct.service.implement;

import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.config.CloudinaryConfig;
import vsii.edu.updateproduct.dto.ThietBiImageDto;
import vsii.edu.updateproduct.entity.ThietBiImage;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.repository.ThietBiImageRepository;
import vsii.edu.updateproduct.service.IUploadImageService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadImageServiceImpl implements IUploadImageService {
    @Autowired
    private ThietBiImageRepository thietBiImageRepository;
    @Autowired
    private final CloudinaryConfig cloudinaryConfig;
    /**
     * Ham nay de lay ra url image cua thiet bi theo id
     *
     * @param thietBiId
     * @return tra ve url image neu thanh cong, that bai nem ra exception
     */
//    @Override
//    public String getByThietBiId(Long id) throws Exception {
//
//        ThietBiImage existThietBiImage= thietBiImageRepository.getByThietBi_idThietBi(id);
//        if (existThietBiImage == null) {
//            throw new DataNotFoundException("Not found thiet bi image by thiet bi id " + id);
//        }
//        return getImageUrlFromCloudinary(existThietBiImage.getImageUrl());
//
//    }

    /**
     * Method nay lay ra url image theo public_id cua image do tren cloudinary
     *
     * @param publicId truyen vao public_id dai dien cho moi image khi duoc upload len cloudinary
     *
     * @return tra ve url image
     *
     * @throws Exception
     */
//    public String getImageUrlFromCloudinary(String publicId) throws Exception {
//        Map<String, Object> resource = cloudinaryConfig.cloudinary().api().resource(publicId, ObjectUtils.asMap(
//                "resource_type", "image"
//        ));
//
//        // url tu map rouse
//        return (String) resource.get("url");
//    }


}

