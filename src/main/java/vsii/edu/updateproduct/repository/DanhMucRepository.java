package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.entity.ThietBi;

import java.util.List;

/**
 * Viết các truy vấn tới csdl cụ thể là bảng Danh Mục
 */
@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc,Long> {
    /**
     * lấy  tất cả các đối tượng Danh Muc từ cơ sở dữ liệu
     * @return list Danh Muc
     * @see DanhMuc
     */
    @Query("select p from DanhMuc p")
    List<DanhMuc> getDanhMuc();

}
