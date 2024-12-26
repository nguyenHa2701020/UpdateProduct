package vsii.edu.updateproduct.service;

import org.springframework.stereotype.Service;
import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;

import java.util.List;

/**
 * lớp IKhuVucService khai báo phương thức lstKhuVuc
 */
public interface IKhuVucService {
    /**
     * Lâấy danh sách tất cả khu vực
     * @return danh sách khu vực
     * @see KhuVuc
     */
    List<KhuVuc> lstKhuVuc() throws DataNotFoundException;
}
