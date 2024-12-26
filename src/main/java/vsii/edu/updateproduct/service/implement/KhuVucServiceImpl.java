package vsii.edu.updateproduct.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.repository.KhuVucRepository;
import vsii.edu.updateproduct.service.IKhuVucService;
import vsii.edu.updateproduct.util.MessageKey;

import java.util.List;

/**
 * Xử lý logic nghiệp vụ liên quan đên KhuVuc
 */
@Service
public class KhuVucServiceImpl implements IKhuVucService {
    @Autowired
    private KhuVucRepository khuVucRepository;

    /**
     * * Phương thức này gọi đến repository để truy xuất tất cả các bản ghi từ bảng KhuVuc
     *
     * @return Danh sách các đối tượng KhuVuc
     */
    @Override
    public List<KhuVuc> lstKhuVuc() throws DataNotFoundException {
        List<KhuVuc> khuVucList = khuVucRepository.getKhuVuc();
        if (khuVucList.isEmpty()) {
            // tra ve voi ma 404 khong co du lieu
            throw new DataNotFoundException(Translator.toLocale(MessageKey.NOT_FOUND));
        }
        // tra ve trang thai 200 khi lay thong tin khu vuc thanh cong

        return khuVucList;
    }

}

