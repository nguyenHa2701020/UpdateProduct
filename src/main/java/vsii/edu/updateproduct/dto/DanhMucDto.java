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
/**
 * cung cấp mô tả chi tiết về lớp DanhMucDto
 */
@Schema(
        name = "DanhMucDto",
        description = "DanhMucDto to hold Danh muc information"
)
public class DanhMucDto {

    /**
     * Mô tả thông tin về thuộc tính idDanhMuc
     */
    @Schema(
            description = " danhmuc id of  DanhMuc", example = "0123456"
    )
    private Long idDanhMuc;


    /**
     * Mô tả thông tin và validate về thuộc tính tenDanhMuc
     */
    @Schema(
            description = " danhmuc name of DanhMuc", example = "Thang nâng"
    )
    @NotEmpty(message = " danhmuc name can not be a null or empty")
    private String tenDanhMuc;


    /**
     * Mô tả thông tin và validate dữ liệu về thuộc tính model
     */
    @Schema(
            description = "danhmuc model of Danh Muc", example = "Z-80/60"
    )
    @NotEmpty(message = "Model can not be a null or empty")
    private String model;
    /**
     * Validate dữ liệu về thuộc tính idThietBi
     */
    @Schema(
    )
    @NotEmpty(message = " idThietBi can not be a null or empty")
    private long idThietBi;
}
