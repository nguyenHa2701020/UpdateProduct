package vsii.edu.updateproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.entity.ThuongHieu;

import java.util.Date;
import java.util.List;
/**
 * Viết các truy vấn tới csdl cụ thể là bảng Thiet Bi
 */
@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi,Long> {
    /**
     * lấy  tất cả các đối tượng ThietBi từ cơ sở dữ liệu
     * @return list Thiet Bi
     * @see ThietBi
     */
    @Query("select p from ThietBi p")
    List<ThietBi> getThietBi();
    /**
     * gọi thủ tục update_product trong csdl
     * @param idThietBi
     * @param trangThai
     * @param tinhTrang
     * @param serial
     * @param namSanXuat
     * @param thoiGianBanGiao
     * @param moTa
     * @param gia
     * @param sucChua
     * @param height
     * @param danhMucFile
     * @param thongTinSai
     * @param giaBan
     * @param idDM
     * @param idKvuc
     * @param idTH
     */
    @Procedure(name = "update_product")
    void UpdateThietBi(
            @Param("p_idThietBi") long idThietBi,
            @Param("p_trangThai") String trangThai,
            @Param("p_tinhTrang") String tinhTrang,
            @Param("p_serial") long serial,
            @Param("p_namSanXuat") Date namSanXuat,
            @Param("p_thoiGianBanGiao") Date thoiGianBanGiao,
            @Param("p_moTa")String moTa,
            @Param("p_gia") float gia,
            @Param("p_sucChua") float sucChua,
            @Param("p_height") float height,
            @Param("p_danhMucFile") String danhMucFile,
            @Param("p_thongTinSai") String thongTinSai,
            @Param("p_giaBan") float giaBan,
            @Param("p_idDanhMuc") long idDM,
            @Param("p_idKhuVuc") long idKvuc,
            @Param("p_idThuongHieu") long idTH

    );
}
