package vsii.edu.updateproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * lop entity nay dai dien cho doi tuong Thiet Bi voi cac thuoc tinh cua doi tuong
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ThietBi")
public class ThietBi {
    /**
     * Đánh dấu đây là khóa chính (Primary Key) của bảng và tự động tăng
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thiet_bi_id")
    private long idThietBi;
    private String trangThai;
    private String tinhTrang;
    private long serial;
    private Date namSanXuat;
    private Date thoiGianBanGiao;
    private String moTa;
    private float gia;
    private float sucChua;
    private float height;
    private String danhMucFile;
    private String thongTinSai;
    private float giaBan;
    /**
     * @ManyToOne: Đánh dấu quan hệ giữa Entity ThietBi và DanhMuc là quan hệ nhiều đến một (Many-to-One).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "danh_muc_id", referencedColumnName = "danh_muc_id")
    private DanhMuc danhmuc;
    /**
     * Đánh dấu quan hệ giữa Entity ThietBi và KhuVuc là quan hệ nhiều đến một (Many-to-One).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khu_vuc_id", referencedColumnName = "khu_vuc_id")
    private KhuVuc khuvuc;
    /**
     * Đánh dấu quan hệ giữa Entity ThietBi và ThuongHieu là quan hệ nhiều đến một (Many-to-One).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "thuong_hieu_id", referencedColumnName = "thuong_hieu_id")
    private ThuongHieu thuonghieu;

    @OneToMany(mappedBy = "thietBi", cascade = CascadeType.ALL)
    private List<ThietBiImage> thietBiImage;
}
