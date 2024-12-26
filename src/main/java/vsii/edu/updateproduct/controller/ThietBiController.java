package vsii.edu.updateproduct.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.config.CloudinaryConfig;
import vsii.edu.updateproduct.dto.ThietBiDto;
import vsii.edu.updateproduct.entity.ThietBi;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.service.IThietBiService;
import vsii.edu.updateproduct.util.ApiResponseStatus;
import vsii.edu.updateproduct.util.GlobalResponse;
import vsii.edu.updateproduct.util.MessageKey;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Tag(
        name = " REST APIs for ThietBi ",
        description = " REST APIs for ThietBi "
)
@RestController
@RequestMapping("/api/thietbi")
@Validated
@Slf4j
public class ThietBiController {
    @Autowired
    private IThietBiService thietBiService;


    /**
     * API này để lấy danh sách các thiết bị.
     * Phương thức này sẽ gọi service để lấy danh sách các thiet bi từ cơ sở dữ liệu
     * và trả về kết quả dưới dạng ResponseEntity.
     *
     * @return ResponseEntity chứa danh sách thiet bi và mã trạng thái HTTP 200 (OK).
     *
     * @throws DataNotFoundException nếu không tìm thấy thiet bi trong cơ sở dữ liệu.
     */
    @GetMapping("/")
    @Operation(

            description = "REST API lay thong tin thiet bi"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lay danh sach thiet bi thanh cong"),
            @ApiResponse(responseCode = "404", description = "Khong tim thay thiet bi "),
            @ApiResponse(responseCode = "400", description = "Lỗi phía máy khách khi dữ liệu đầu vào không hợp lệ như đã xác thực "),
            @ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ khi không kết nối được với cơ sở dữ liệu")
    })
    //ham lay thong tin thiet bi
    public ResponseEntity<Map<String, Object>> lstThietBi() throws DataNotFoundException {
        // Lấy danh sách từ service
        List<ThietBi> thietBiList = thietBiService.lstThietBi();
        // Trả về kết quả dưới dạng ResponseEntity với mã trạng thái OK và danh sách thiet bi
        return ResponseEntity.ok(GlobalResponse.buildResponse(ApiResponseStatus.SUCCESS, thietBiList));

    }

    @PostMapping("/update")
    @Operation(

            description = "REST API update thong tin thiet bi"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update thiet bi thanh cong"),
            @ApiResponse(responseCode = "404", description = "Khong tim thay thiet bi "),
            @ApiResponse(responseCode = "400", description = "Lỗi phía máy khách khi dữ liệu đầu vào không hợp lệ như đã xác thực "),
            @ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ khi không kết nối được với cơ sở dữ liệu")
    })
    /**
     *  Phương thức này xử lý yêu cầu cập nhật thông tin của thiết bị từ client
     *   @param thietbi Đối tượng DTO chứa thông tin của thiết bị cần cập nhật.
     *   @return phản hồi HTTP với trạng thái thành công hoặc thất bại.
     *  Nếu thành công, sẽ trả về mã trạng thái 200 (OK) cùng với dữ liệu thiết bị đã cập nhật.
     *  Nếu có lỗi, sẽ trả về các mã trạng thái lỗi tương ứng như 400, 404, hoặc 500.
     *  @throws DataNotFoundException Nếu không tìm thấy thiết bị với ID được cung cấp trong yêu cầu.
     *  */

    public ResponseEntity<?> updateThietBi(@RequestBody @Valid ThietBiDto thietbi) throws MethodArgumentNotValidException, DataNotFoundException {

        // Gọi service để cập nhật thiết bị
        // Phương thức này sẽ xử lý logic cập nhật trong cơ sở dữ liệu
        thietBiService.updateThietBi(thietbi);

        // Trả về phản hồi 200 thành công, với dữ liệu thiết bị đã được cập nhật
        // Dữ liệu này sẽ được phản hồi dưới dạng JSON
        return ResponseEntity.ok(GlobalResponse.buildResponse(ApiResponseStatus.SUCCESS, thietbi));

    }

    /**
     * Phuong thuc de upload image len cloudinary cho thiet bi tuong ung qua thiet bi id
     * Dieu kien upload image: Chi 1 image duoc upload
     * Kich thuoc video duoi 5MB
     * Video upload phai dung dinh dang
     *
     * @param courseId      id cua khoa hoc tuong ung de upload video.
     * @param multipartFile tep video can upload len cloudinary
     *
     * @return tra ve ok thanh cong va message, neu that bai nem ra exception.
     */
    @Operation(summary = "Upload image to cloudinary", description = "Send a request via this API to upload image of the thiet bi to cloudinary" + "Conditions: just only video file - \n" + "video size smaller then 20MB - \n" + "Video file while upload must follow format standards example(mp4, mov,...)")
    @PostMapping(value = "/uploadImage/{thiet_bi_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved video of course"),
            @ApiResponse(responseCode = "404", description = "Not found url of data"),
            @ApiResponse(responseCode = "500", description = "Internal server error while not connect with database and can't access to cloudinary")})
    public ResponseEntity<?> uploadFile(@PathVariable(name = "thiet_bi_id") @Min(1) Long thietBiId, @RequestPart("image") MultipartFile multipartFile) throws DataNotFoundException, IOException {


        // kiem tra course id co ton tai ?
        try {


            if (thietBiId <= 0) {
                throw new DataNotFoundException("Not found URL or data");
            }


            // goi service de upload video
            Map<String, Object> uploadResult = thietBiService.uploadFileToCloudinary(thietBiId, multipartFile);
            log.info("Upload successful for thietBiId: {}", thietBiId);

            // tra ve 200 khi upload video thanh cong
            return ResponseEntity.ok(GlobalResponse.buildResponse(ApiResponseStatus.SUCCESS, uploadResult.get("imageUrl")));
        } catch (DataNotFoundException e) {
            // Log thông tin lỗi khi không tìm thấy dữ liệu
            log.error("DataNotFoundException: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
     catch (IOException e) {
        // Log lỗi liên quan đến việc xử lý file (upload, đọc tệp)
        log.error("IOException occurred while uploading file: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: File upload failed due to IO exception.");
    } catch (Exception e) {
        // Log bất kỳ lỗi nào khác
        log.error("An unexpec   ted error occurred: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred while uploading the image.");
    }


    }
}

