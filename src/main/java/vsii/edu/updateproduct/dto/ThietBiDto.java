package vsii.edu.updateproduct.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * lop nay  chua cac du lieu de chuyen doi cac du lieu tu entity
 * cac truong du lieu se duoc validate tuong ung voi dac ta yeu cau
 */
@Data
@AllArgsConstructor

@Setter
/**
 * cung cấp mô tả chi tiết về lớp ThietBiDto
 */
@Schema(
        name = "ThietBiDto",
        description = "ThietBiDto to hold Thiet bi information"
)
public class ThietBiDto {

    /**
     * Mô tả thông tin về thuộc tính idThietBi
     */
    @Schema(
            description = " thietbi id of  ThietBi", example = "10"
    )
    private  Long idThietBi;

    /**
     * Mô tả thông tin về thuộc tính trangThai
     */
    @Schema(
            description = " trangthai of ThietBi", example = "Còn hàng"
    )
    private String trangThai;

    /**
     * Mô tả thông tin về thuộc tính tinhTrang
     */
    @Schema(
            description = "tinhtrang  of ThietBi", example = "Đã qua sử dụng"
    )
    private String tinhTrang;


    /**
     * Mô tả thông tin về thuộc tính serial
     */
    @Schema(
            description = "  serial of ThietBi", example = "0123"
    )
    private long serial;


    /**
     * Mô tả thông tin về thuộc tính namSanXuat
     */
    @Schema(
            description = "namSanXuat of ThietBi", example = "2019"
    )
    private Date namSanXuat;


    /**
     * Mô tả thông tin về thuộc tính thoiGianBanGiao
     */
    @Schema(
            description = " thoigianbangiao of ThietBi", example = "example"
    )
    private Date thoiGianBanGiao;

    /**
     * Mô tả thông tin về thuộc tính moTa
     */
    @Schema(
            description = " mota of ThietBi", example = "example"
    )
    private String moTa;


    /**
     * Mô tả thông tin về thuộc tính gia
     */
    @Schema(
            description = "gia of ThietBi", example = "2.500.000.000"
    )
    private float gia;


    /**
     * Mô tả thông tin về thuộc tính sucChua
     */
    @Schema(
            description = " sucChua of ThietBi", example = "227"
    )
    @NotEmpty(message = " sucChua  can not be a null or empty")
    private float sucChua;


    /**
     * Mô tả thông tin về thuộc tính height
     */
    @Schema(
            description = "height of ThietBi", example = "23.77"
    )
    @NotEmpty(message = "height can not be a null or empty")
    private float height;


    /**
     * Mô tả thông tin về thuộc tính danhMucFile
     */
    @Schema(
            description = " danhmuc file of ThietBi", example = "tt"
    )
    private String danhMucFile;


    /**
     * Mô tả thông tin về thuộc tính thongTinSai
     */
    @Schema(
            description = "thongtinsai of ThietBi", example = "sai"
    )
    private String thongTinSai;


    /**
     * Mô tả thông tin về thuộc tính giaBan
     */
    @Schema(
            description = "giaban  of ThietBi", example = "2.500.000.000"
    )
    private float giaBan;


    /**
     * Validate dữ liệu về thuộc tính idDanhMuc
     */
    @NotEmpty(message = " idThietBi can not be a null or empty")
    private long idDanhMuc;


    /**
     * Validate dữ liệu về thuộc tính idKhuVuc
     */
    @NotEmpty(message = " idKhuVuc can not be a null or empty")
    private long idKhuVuc;


    /**
     * Validate dữ liệu về thuộc tính idThuongHieu
     */
    @NotEmpty(message = " idThuongHieu can not be a null or empty")
    private long idThuongHieu;


}
