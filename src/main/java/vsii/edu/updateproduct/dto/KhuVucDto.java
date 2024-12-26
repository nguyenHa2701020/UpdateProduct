package vsii.edu.updateproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * lop nay  chua cac du lieu de chuyen doi cac du lieu tu entity
 * cac truong du lieu se duoc validate tuong ung voi dac ta yeu cau
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
/**
 * cung cấp mô tả chi tiết về lớp KhuVucDto
 */
@Schema(
        name = "KhuVucDto",
        description = "KhuVucDto to hold Khu vuc information"
)
public class KhuVucDto {
    /**
     * Mô tả thông tin về thuộc tính idKhuVuc
     */
    @Schema(
            description = " khuvuc id of  KhuVuc", example = "10"
    )
    private Long idKhuVuc;

    /**
     * Mô tả thông tin về thuộc tính thanhPho
     */
    @Schema(
            description = " thanhpho  of KhuVuc", example = "Ha Noi"
    )
    @NotEmpty(message = " thanh pho can not be a null or empty")
    private String thanhPho;

    /**
     * Mô tả thông tin về thuộc tính maBuuDien
     */
    @Schema(
            description = " ma buu dien  of KhuVuc", example = "100000"
    )
    private String maBuuDien;

    /**
     * Mô tả thông tin về thuộc tính diaChiCuThe
     */
    @Schema(
            description = "dia chi cu the of Danh Muc", example = "dinh cong hoang mai ha noi"
    )

    private String diaChiCuThe;

    /**
     * Validate dữ liệu về thuộc tính idThietBi
     */
    @Schema(
    )
    @NotEmpty(message = " idThietBi can not be a null or empty")
    private long idThietBi;
}
