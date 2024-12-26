package vsii.edu.updateproduct.service;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import vsii.edu.updateproduct.dto.ThietBiDto;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.exception.DataNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * interface IThietBiService khai báo phương thức lstThietBi và  updateThietBi
 */

public interface IThietBiService {
    /**
     * Lấy danh sách tất cả thiết bị
     *
     * @return danh sách thiết bị
     *
     * @see ThietBi
     */
    List<ThietBi> lstThietBi() throws DataNotFoundException;

    /**
     * Cập nhật thông tin một thiết bị
     *
     * @param ThietBiDto
     *
     * @return thiết bị sau khi cập nhật
     *
     * @throws DataNotFoundException, IllegalArgumentException
     * @see ThietBiDto
     * @see DataNotFoundException
     * @see IllegalArgumentException
     */
    void updateThietBi(ThietBiDto thietBiDto) throws MethodArgumentNotValidException, DataNotFoundException;

    /**
     * Function: De upload file len cloudinary
     *
     * @param courseId      course id de upload video cho khoa hoc theo id nay
     * @param multipartFile file video de upload(file dung dinh dang, max size 100MB, chi upload 1 file duy nhat)
     * @return tra re Map<String, Object> result chua cac thong tin ve 1 file khi duoc upload tren cloudinary
     * @throws IOException nem ex khi loi lien quan den file (khi file khong doc duoc hay khong tim thay file)
     * @throws DataNotFoundException nem ex ma loi 404 khi tim khoa hoc theo courseId khong tim thay
     * @throws MaxUploadSizeExceededException nem ex ma loi 413 khi file lon hon size mac dinh (100MB)
     */
    public Map<String, Object> uploadFileToCloudinary(Long idThietBi, MultipartFile multipartFile) throws DataNotFoundException, IOException, MaxUploadSizeExceededException;
}

