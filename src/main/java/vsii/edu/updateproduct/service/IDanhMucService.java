package vsii.edu.updateproduct.service;

import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;

import java.util.List;
/**
 * lớp IDanhMucService khai báo phương thức lstDanhMuc
 */
public interface IDanhMucService {
    /**
     * Lâấy danh sách tất cả danh mục
     * @return danh sách danh mục
     * @see DanhMuc
     */
    List<DanhMuc> lstDanhMuc() throws DataNotFoundException;
}
