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
import vsii.edu.updateproduct.entity.KhuVuc;
import vsii.edu.updateproduct.exception.DataNotFoundException;
import vsii.edu.updateproduct.service.IKhuVucService;
import vsii.edu.updateproduct.util.ApiResponseStatus;
import vsii.edu.updateproduct.util.GlobalResponse;

import java.util.List;
import java.util.Map;

@Tag(
        name = "Lay thong tin khu vuc tu KhuVuc ",
        description = "'Lay thong tin kho bai de thiet bi  "
)
@RestController
@RequestMapping("/api/khuvuc")

@Slf4j
public class KhuVucController {
    @Autowired
    private IKhuVucService khuVucService;
    /**
     * API này để lấy danh sách các khu vực.
     * Phương thức này sẽ gọi service để lấy danh sách các khu vuc từ cơ sở dữ liệu
     * và trả về kết quả dưới dạng ResponseEntity.
     *
     * @return ResponseEntity chứa danh sách khu vuc và mã trạng thái HTTP 200 (OK).
     * @throws DataNotFoundException nếu không tìm thấy khu vuc trong cơ sở dữ liệu.
     * */
    @GetMapping("/")
    @Operation(

            description = "REST API lay thong tin kho bai de thiet bi "
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lay danh sach khu vuc thanh cong"),
            @ApiResponse(responseCode = "404", description = "Khong tim thay khu vuc "),
            @ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ khi không kết nối được với cơ sở dữ liệu")
    })
    //ham lay thong tin khu vuc
    public ResponseEntity<Map<String,Object>> lstKhuVuc() throws DataNotFoundException {
        // Lấy danh sách từ service
        List<KhuVuc> khuVucList = khuVucService.lstKhuVuc();
        // Trả về kết quả dưới dạng ResponseEntity với mã trạng thái OK và danh sách khu vuc
        return ResponseEntity.ok(GlobalResponse.buildResponse(ApiResponseStatus.SUCCESS, khuVucList));



    }
}