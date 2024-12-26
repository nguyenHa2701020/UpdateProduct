package vsii.edu.updateproduct.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * ResponseData su dung de dung chung cho cac phan hoi.
 * Gom 3 truong status (trang thai response), message (thong diep), data(du lieu dang object).
 * de ap dung cho kieu phan hoi cho cac response khac khi can mo rong.
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageSuccess  {
    private String message;
//    public MessageSuccess(HttpStatus status, String message) {
//        super(new Payload(status.value(), message), HttpStatus.OK);
//    }
//
//    public MessageSuccess(HttpStatus status, String message, Object data) {
//        super(new Payload(status.value(), message, data), status);
//    }
//
//    public MessageSuccess(Payload body, HttpStatus status) {
//        super(body, status);
//    }
//
//    public MessageSuccess(MultiValueMap<String, String> headers, HttpStatus status) {
//        super(headers, status);
//    }
//
//    public MessageSuccess(Payload payload, MultiValueMap<String, String> headers, int rawStatus) {
//        super(payload, headers, rawStatus);
//    }
//
//    public MessageSuccess(Payload payload, MultiValueMap<String, String> headers, HttpStatus status) {
//        super(payload, headers, status);
//    }
//
//    @Getter
//    public static class Payload {
//        private final int status;
//        private final String message;
//        @JsonInclude(JsonInclude.Include.NON_NULL)
//        private Object data;
//
//        public Payload(int status, String message) {
//            this.status = status;
//            this.message = message;
//        }
//
//        public Payload(int status, String message, Object data) {
//            this.status = status;
//            this.message = message;
//            this.data = data;
//        }
 //   }
}
