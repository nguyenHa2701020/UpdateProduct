package vsii.edu.updateproduct.exception;
/**
 * Exception cho các trường hợp không tìm thấy dữ liệu
 */
public class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}
