package vsii.edu.updateproduct.util;

import java.util.Arrays;
import java.util.List;

public class ConstantKey {
    public static final List<String> VALID_CONTENT_TYPES = Arrays.asList(
            "image/jpeg",   // JPEG/JPG
            "image/png",    // PNG
            "image/gif",    // GIF
            "image/bmp",    // BMP
            "image/webp"  ); //WEBP
    public static final long MAX_FILE_SIZE_MB = 5 * 1024 * 1024; // 5MB max size
}
