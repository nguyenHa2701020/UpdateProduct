package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.entity.ThuongHieu;

import java.util.List;
/**
 * Viết các truy vấn tới csdl cụ thể là bảng Thuong Hieu
 */
@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Long> {
    /**
     * lấy  tất cả các đối tượng ThuongHieu từ cơ sở dữ liệu
     * @return list Thuong Hieu
     * @see ThuongHieu
     */
    @Query("select p from ThuongHieu p")
    List<ThuongHieu> getThuongHieu();
}
