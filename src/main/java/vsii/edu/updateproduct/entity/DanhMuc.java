package vsii.edu.updateproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * lop entity nay dai dien cho doi tuong Danh Muc voi cac thuoc tinh cua doi tuong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Danhmuc")

public class DanhMuc {
    /**
     * Đánh dấu đây là khóa chính (Primary Key) của bảng và tự động tăng
     */
    @Id  //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "danh_muc_id")

    private long idDanhMuc;
    private String tenDanhMuc;
    private String model;
    @JsonBackReference
    /**
     * Thiết lập mối quan hệ One-to-Many với Entity ThietBi
     */
    @OneToMany(mappedBy = "danhmuc", cascade = CascadeType.ALL)
    private List<ThietBi> thietbi;
}
