package vsii.edu.updateproduct.service.implement;

import com.cloudinary.utils.ObjectUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.config.CloudinaryConfig;
import vsii.edu.updateproduct.dto.ThietBiDto;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.entity.ThietBiImage;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.repository.ThietBiImageRepository;
import vsii.edu.updateproduct.repository.ThietBiRepository;
import vsii.edu.updateproduct.service.IThietBiService;
import vsii.edu.updateproduct.util.ConstantKey;
import vsii.edu.updateproduct.util.MessageKey;

import java.io.IOException;
import java.util.*;

/**
 * Xử lý logic nghiệp vụ liên quan đên Thiet Bi
 */
@Service
@RequiredArgsConstructor
public class ThietBiServiceImpl  implements IThietBiService {
    @Autowired
    private ThietBiRepository thietBiRepository;
    @Autowired
    private final CloudinaryConfig cloudinaryConfig;
    @Autowired
    private final ThietBiImageRepository thietBiImageRepository;
    /**
     * * Phương thức này gọi đến repository để truy xuất tất cả các bản ghi từ bảng ThietBi
     *
     * @return Danh sách các đối tượng ThietBi
     */
    @Override
    public List<ThietBi> lstThietBi() throws DataNotFoundException {
        List<ThietBi> thietBiList = thietBiRepository.getThietBi();
        if (thietBiList.isEmpty()) {
            // tra ve voi ma 404 khong co du lieu
            throw new DataNotFoundException(Translator.toLocale(MessageKey.NOT_FOUND));
        }
        // tra ve trang thai 200 khi lay thong tin khu vuc thanh cong

        return thietBiList;
    }
    /**
     * Cập nhật thông tin thiết bị
     * @param thietBiDto
     * @throws DataNotFoundException, IllegalArgumentException
     * @see ThietBiDto
     * @see DataNotFoundException
     * @see IllegalArgumentException
     */
    @Transactional
    @Override
    public void updateThietBi(ThietBiDto thietBiDto) throws MethodArgumentNotValidException, DataNotFoundException {
        // kiem tra su ton tai cua thiet bi theo idThietBi
        ThietBi existsIdThietBi = thietBiRepository.findById(thietBiDto.getIdThietBi())
                .orElseThrow(() -> new DataNotFoundException("Cannot find thiet bi with id: " + thietBiDto.getIdThietBi()));
        ThietBi existsIdDanhMuc = thietBiRepository.findById(thietBiDto.getIdDanhMuc())
                .orElseThrow(() -> new DataNotFoundException("Cannot find danh muc with id: " + thietBiDto.getIdDanhMuc()));
        ThietBi existsIdKhuVuc = thietBiRepository.findById(thietBiDto.getIdKhuVuc())
                .orElseThrow(() -> new DataNotFoundException("Cannot find khu vuc with id: " + thietBiDto.getIdKhuVuc()));
        ThietBi existsIdThuongHieu = thietBiRepository.findById(thietBiDto.getIdThuongHieu())
                .orElseThrow(() -> new DataNotFoundException("Cannot find thuong hieu with id: " + thietBiDto.getIdThuongHieu()));

        thietBiRepository.UpdateThietBi(thietBiDto.getIdThietBi(), thietBiDto.getTrangThai(),
                thietBiDto.getTinhTrang(), thietBiDto.getSerial(), thietBiDto.getNamSanXuat(),
                thietBiDto.getThoiGianBanGiao(), thietBiDto.getMoTa(), thietBiDto.getGia(),
                thietBiDto.getSucChua(), thietBiDto.getHeight(), thietBiDto.getDanhMucFile(),
                thietBiDto.getThongTinSai(), thietBiDto.getGiaBan(), thietBiDto.getIdDanhMuc(),
                thietBiDto.getIdKhuVuc(), thietBiDto.getIdThuongHieu());
    }
    /**
     *
     * @param imageFile file image dang MultipartFile
     * @throws IOException nem ra ex khi khong tim thay file hoac file sai dinh dang
     */
    private void validateImageFile(MultipartFile imageFile) throws IOException {

        if (imageFile == null || imageFile.isEmpty()) {
            throw new IOException(Translator.toLocale(MessageKey.UPLOAD_FILE_EMPTY));
        }
        if (imageFile.getSize() > ConstantKey.MAX_FILE_SIZE_MB) {
            throw new IOException(Translator.toLocale(MessageKey.UPLOAD_FILE_EXCEED_SIZE));
        }
        if (!ConstantKey.VALID_CONTENT_TYPES.contains(imageFile.getContentType())) {
            throw new IOException(Translator.toLocale(MessageKey.UPLOAD_FILE_FORMAT_FAILED));
        }
    }

    /**
     *
     * @param thietBiId   id thiet bi tuong ung voi image cua thiet bi do
     * @param imageFile file image de upload len cloudinary
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, Object> uploadFileToCloudinary(Long thietBiId, MultipartFile imageFile) throws  DataNotFoundException, IOException {
        Map<String, Object> uploadResult = new HashMap<>();


        // Goi ham validate de ktra file truoc khi upload

        validateImageFile(imageFile);
        // kiem tra su ton tai cua thiet bi
        Optional<ThietBi> existsThietBi = thietBiRepository.findById(thietBiId);
        if (existsThietBi.get() == null) {
            throw new DataNotFoundException("Cannot find thiet bi with id: " + thietBiId);
        }
        String fileNameUnique = imageFile.getOriginalFilename() +"_" + UUID.randomUUID().toString();
        // upload video len cloudinary
        Map result = cloudinaryConfig.cloudinary().uploader().upload(imageFile.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "image",
                        "public_id",fileNameUnique
                ));

        // get video url save to db
        String imageUrl = result.get("secure_url").toString();
        ThietBiImage thietBiImage = ThietBiImage.builder()
                .thietBi(existsThietBi.get())
                .imageUrl(fileNameUnique)
                .build();
        thietBiImageRepository.save(thietBiImage);

        uploadResult.put("imageUrl", imageUrl);
        uploadResult.put("message", Translator.toLocale(MessageKey.UPLOAD_FILE_SUCCESSFULLY));
        return uploadResult;
    }



}
