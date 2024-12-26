package vsii.edu.updateproduct.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * class Translator dung de lay thong diep tu file message.properties
 * dịch chúng thành thông điệp người dùng có thể hiểu được, đặc biệt là khi ứng dụng hỗ trợ đa ngôn ngữ.
 */
@Component
public class Translator {

    private static ResourceBundleMessageSource messageSource;

    /**
     * nhận và khởi tạo đối tượng ResourceBundleMessageSource
     *
     * @param messageSource nhan ma thong diep
     */
    private Translator(@Autowired ResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }


    /**
     * lay thong diep tu file message.properties dua tren ma message code va su dung ngon ngu hien tai cua he thong
     *
     * @param msgCode - ma thong diep
     *
     * @return thong diep se tra ve theo ngon ngu da chon neu khong thi return null
     */
    public static String toLocale(String msgCode, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(msgCode, args, locale);
        return message;
    }
}