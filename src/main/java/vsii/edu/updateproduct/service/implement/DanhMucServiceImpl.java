package vsii.edu.updateproduct.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.repository.DanhMucRepository;
import vsii.edu.updateproduct.service.IDanhMucService;
import vsii.edu.updateproduct.util.MessageKey;

import java.util.List;

/**
 * Xử lý logic nghiệp vụ liên quan đên Danh Muc
 */
@Slf4j
@Service
public class DanhMucServiceImpl implements IDanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    /**
     * * Phương thức này gọi đến repository để truy xuất tất cả các bản ghi từ bảng DanhMuc
     * @return Danh sách các đối tượng DanhMuc
     */
    @Override
    public List<DanhMuc> lstDanhMuc() throws DataNotFoundException {
        List<DanhMuc> danhMucList = danhMucRepository.getDanhMuc();
        if (danhMucList.isEmpty()) {
            // tra ve voi ma 404 khong co du lieu
            throw new DataNotFoundException(Translator.toLocale(MessageKey.NOT_FOUND));
        }
        // tra ve trang thai 200 khi lay thong tin danh muc thanh cong

        return danhMucList;
    }
}
