package vsii.edu.updateproduct.service;

import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.entity.ThuongHieu;
import vsii.edu.updateproduct.exception.DataNotFoundException;

import java.util.List;
/**
 * lớp IThuongHieuService khai báo phương thức lstThuongHieu
 */
public interface IThuongHieuService {
    /**
     * Lấy danh sách tất cả thương hiệu
     * @return danh sách thương hiệu
     * @see ThuongHieu
     */
    List<ThuongHieu> lstThuongHieu() throws DataNotFoundException;
}
