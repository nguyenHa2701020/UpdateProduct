package vsii.edu.updateproduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import vsii.edu.updateproduct.component.Translator;
import vsii.edu.updateproduct.util.ApiResponseStatus;
import vsii.edu.updateproduct.util.GlobalResponse;
import vsii.edu.updateproduct.util.MessageKey;

import java.security.GeneralSecurityException;
import java.util.Map;

/**
 * GlobalExceptionHandler xử lý toàn bộ các vấn đề liên quan đến ngoại lệ (exception) và cung cấp phản hồi lỗi đồng nhất cho frontend.
 * Phương thức xử lý lỗi trong GlobalExceptionHandler sẽ tùy chỉnh phản hồi lỗi theo mã trạng thái HTTP phù hợp (400, 500,404).
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * xử lý ngoại lệ MethodArgumentNotValidException  ví dụ như @Not null
     * @param ngoại lệ MethodArgumentNotValidException  được ném ra
     * @return ResponseEntity chứa thông điệp lỗi và mã trạng thái 400
     */
    @ExceptionHandler(MethodArgumentNotValidException .class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException (MethodArgumentNotValidException  ex) {
        return ResponseEntity.status(ApiResponseStatus.BAD_REQUEST.getStatus())
                .body(GlobalResponse.buildResponse(ApiResponseStatus.BAD_REQUEST, null));
    }


    /**
     * xử lý ngoại lệ DataNotFoundException ví dụ như không tìm thấy id khóa ngoại
     * @param ngoại lệ DataNotFoundException được ném ra
     * @return ResponseEntity chứa thông điệp lỗi và mã trạng thái 404
     */
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDataNotFoundException(DataNotFoundException ex) {
     //   return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            return ResponseEntity.status(ApiResponseStatus.NOT_FOUND.getStatus())
                    .body(GlobalResponse.buildResponse(ApiResponseStatus.NOT_FOUND, null));
        }


    /**
     * Xử lý ngoại lệ RuntimeException.
     * Khi gặp lỗi RuntimeException (ví dụ: lỗi không xác định hoặc lỗi bất thường),
     * phương thức này sẽ bắt ngoại lệ và trả về phản hồi HTTP với mã trạng thái 500 (Internal Server Error).
     *
     * @param ex ngoại lệ RuntimeException được ném ra
     *
     * @return ResponseEntity chứa thông điệp lỗi và mã trạng thái 500
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(ApiResponseStatus.INTERNAL_SERVER_ERROR.getStatus())
                .body(ex.getMessage());
    }



    /**
     * xu ly ngoai le voi MaxUploadSizeExceededException cho viec upload file qua gioi han
     * @param exc
     * @return return ma loi 413
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exc) {

        return ResponseEntity
                .status(HttpStatus.PAYLOAD_TOO_LARGE)
                .body(Translator.toLocale(MessageKey.UPLOAD_FILE_EXCEED_SIZE));
    }

    /**
     * xu ly ngoai le voi GeneralSecurityException cho viec ma hoa, giai ma hay cac thao tac lien quan den qua trinh bao mat
     * @param  ex GeneralSecurityException
     * @return return ma loi 400
     */
    @ExceptionHandler(GeneralSecurityException.class)
    public ResponseEntity<String> handleGeneralSecurityException(GeneralSecurityException ex) {

        return ResponseEntity.status(ApiResponseStatus.BAD_REQUEST.getStatus())
                .body(ex.getMessage());
    }

}
