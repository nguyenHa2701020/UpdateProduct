package vsii.edu.updateproduct.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.entity.ThuongHieu;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.repository.ThuongHieuRepository;
import vsii.edu.updateproduct.service.IThuongHieuService;
import vsii.edu.updateproduct.util.MessageKey;

import java.util.List;

/**
 * Xử lý logic nghiệp vụ liên quan đên KhuVuc
 */
@Service
public class ThuongHieuServiceImpl implements IThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    /**
     * * Phương thức này gọi đến repository để truy xuất tất cả các bản ghi từ bảng ThuongHieu
     * @return Danh sách các đối tượng ThuongHieu
     */
    @Override
    public List<ThuongHieu> lstThuongHieu() throws DataNotFoundException {
        List<ThuongHieu> thuongHieuList = thuongHieuRepository.getThuongHieu();
        if (thuongHieuList.isEmpty()) {
            // tra ve voi ma 404 khong co du lieu
            throw new DataNotFoundException(Translator.toLocale(MessageKey.NOT_FOUND));
        }
        // tra ve trang thai 200 khi lay thong tin khu vuc thanh cong

        return thuongHieuList;
    }

    }

