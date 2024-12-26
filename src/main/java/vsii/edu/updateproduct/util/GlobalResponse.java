package vsii.edu.updateproduct.util;

import java.util.HashMap;
import java.util.Map;

public class GlobalResponse {
    public static Map<String, Object> buildResponse(ApiResponseStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.getStatus().value());
        response.put("message", status.getMessage());
        response.put("data", data);
        return response;
    }
}
