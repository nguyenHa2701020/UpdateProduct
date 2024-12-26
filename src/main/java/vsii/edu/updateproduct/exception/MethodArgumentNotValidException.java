package vsii.edu.updateproduct.exception;

public class MethodArgumentNotValidException  extends Exception{
    /**
     * Exception cho các trường hợp dữ liệu đầu vào không hợp lệ.
     */
        public MethodArgumentNotValidException (String message) {
            super(message);
        }
}
