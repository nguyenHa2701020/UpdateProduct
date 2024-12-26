package vsii.edu.updateproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * lop entity nay dai dien cho doi tuong Thuong Hieu voi cac thuoc tinh cua doi tuong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ThuongHieu")
public class ThuongHieu {
    /**
     * Đánh dấu đây là khóa chính (Primary Key) của bảng và tự động tăng
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thuong_hieu_id")
    private long idThuongHieu;
    private String tenThuongHieu;
    @JsonBackReference
    /**
     * Thiết lập mối quan hệ One-to-Many với Entity ThietBi
     */
    @OneToMany(mappedBy = "thuonghieu", cascade = CascadeType.ALL)
    private List<ThietBi> thietbi;

}