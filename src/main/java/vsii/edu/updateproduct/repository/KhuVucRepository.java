package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.dto.KhuVucDto;
import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.entity.ThietBi;

import java.util.List;
/**
 * Viết các truy vấn tới csdl cụ thể là bảng Khu Vuc
 */
@Repository
public interface KhuVucRepository extends JpaRepository<KhuVuc,Long> {
    /**
     * lấy  tất cả các đối tượng KhuVuc từ cơ sở dữ liệu
     * @return list Khu Vuc
     * @see KhuVuc
     */
    @Query("select p from KhuVuc p")
    List<KhuVuc> getKhuVuc();
}
