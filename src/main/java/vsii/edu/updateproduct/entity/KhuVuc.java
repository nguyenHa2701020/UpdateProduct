package vsii.edu.updateproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * lop entity nay dai dien cho doi tuong Khu Vuc voi cac thuoc tinh cua doi tuong
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "khuvuc")
public class KhuVuc {
    /**
     * Đánh dấu đây là khóa chính (Primary Key) của bảng và tự động tăng
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khu_vuc_id")
    private long idKhuVuc;
    private String thanhPho;
    private String maBuuDien;
    private String diaChiCuThe;
    @JsonBackReference
    /**
     *  Thiết lập mối quan hệ One-to-Many với Entity ThietBi
     */
    @OneToMany(mappedBy = "khuvuc", cascade = CascadeType.ALL)
    private List<ThietBi> thietbi;
}
