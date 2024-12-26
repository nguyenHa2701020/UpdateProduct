package vsii.edu.updateproduct.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vsii.edu.updateproduct.entity.DanhMuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.service.IDanhMucService;
import vsii.edu.updateproduct.util.ApiResponseStatus;
import vsii.edu.updateproduct.util.GlobalResponse;

import java.util.List;
import java.util.Map;


@Tag(
        name = "Lay list danh muc tu DanhMuc ",
        description = "'Lay list danh muc thiet bi  "
)
@RestController
@RequestMapping("/api/danhmuc")

@Slf4j
public class DanhMucController {

    @Autowired
    private IDanhMucService danhMucService;

/**
 * API này để lấy danh sách các danh mục.
 * Phương thức này sẽ gọi service để lấy danh sách các danh mục từ cơ sở dữ liệu
 * và trả về kết quả dưới dạng ResponseEntity.
 *
 * @return ResponseEntity chứa danh sách danh mục và mã trạng thái HTTP 200 (OK).
 * @throws DataNotFoundException nếu không tìm thấy danh mục trong cơ sở dữ liệu.
 * */
    @GetMapping("/danhmucthietbi")
    @Operation(

            description = "REST API to Get list danh muc "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lay danh sach danh muc thanh cong"),
            @ApiResponse(responseCode = "404", description = "Khong tim thay danh muc "),
            @ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ khi không kết nối được với cơ sở dữ liệu")
    })
    //ham lay thong tin danh muc
    public ResponseEntity<Map<String, Object>> lstDanhMuc() throws DataNotFoundException {

        // Lấy danh sách từ service
        List<DanhMuc> danhMucList = danhMucService.lstDanhMuc();

        // Trả về kết quả dưới dạng ResponseEntity với mã trạng thái OK và danh sách danh mục
        return ResponseEntity.ok(GlobalResponse.buildResponse(ApiResponseStatus.SUCCESS, danhMucList));


    }

}
