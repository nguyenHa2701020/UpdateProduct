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
public class ThuongHieuDto {
    /**
     * Mô tả thông tin về thuộc tính idThuongHieu
     */
    @Schema(
            description = " thuonghieu id of  KhuVuc", example = "9"
    )
    private Long idThuongHieu;

    /**
     * Mô tả thông tin về thuộc tính tenThuongHieu
     */
    @Schema(
            description = " thuonghieu name  of KhuVuc", example = "Airman"
    )
    private String tenThuongHieu;

    /**
     * Validate dữ liệu về thuộc tính idThietBi
     */
    @Schema(
    )
    @NotEmpty(message = " idThietBi can not be a null or empty")
    private long idThietBi;
}
