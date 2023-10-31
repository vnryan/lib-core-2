package vn.ryan.core.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppConstants {
    private AppConstants() {
    }

    public static final Map<Integer, String> LEVEL_COURSE = new HashMap<>();
    public static final Map<Integer, String> TYPE_QUESTION = new HashMap<>();

    static {
        LEVEL_COURSE.put(0, "Test đầu vào");
        LEVEL_COURSE.put(1, "Nền tảng");
        LEVEL_COURSE.put(2, "Cơ bản");
        LEVEL_COURSE.put(3, "Nâng cao");
        LEVEL_COURSE.put(4, "Chinh phục");

        TYPE_QUESTION.put(1, "Dạng 1");
        TYPE_QUESTION.put(2, "Dạng 2");
        TYPE_QUESTION.put(3, "Dạng 3");
        TYPE_QUESTION.put(4, "Dạng 4");
        TYPE_QUESTION.put(5, "Dạng 5");
    }

    public static final String APP_RESPONSE_SUCCESS = "Success";
    public static final String APP_RESPONSE_FAILED = "Failed";
    public static final String ACCESS_USER = "access_user";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String AUTHORIZATION = "Authorization";

    public static final String ACCESS_TOKEN_ZALO = "access_token";
    public static final String REFRESH_TOKEN_ZALO = "refresh_token";
    public static final String AUTHORIZATION_CODE_ZALO = "authorization_code";
    public static final String SECRET_KEY_ZALO = "secret_key";

    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_TYPE = "device_type";

    public static final String DATE_TIME_FORMAT_1 = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_2 = "MM/dd/yyyy HH:mm:ss";
    public static final String DATE_MONTH_FORMAT = "yyyyMM";

    public static final List<Integer> PRODUCT_TYPE = Arrays.asList(1, 2, 3, 6, 9, 10);
}
