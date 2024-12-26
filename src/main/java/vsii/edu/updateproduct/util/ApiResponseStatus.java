package vsii.edu.updateproduct.util;

import org.springframework.http.HttpStatus;

public enum ApiResponseStatus {
        SUCCESS(HttpStatus.OK, "Success"),
        NO_CONTENT(HttpStatus.NO_CONTENT, "No content found"),
        BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request data"),
        NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
        INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");

        private final HttpStatus status;
        private  String message;

        ApiResponseStatus(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }

