package vn.ryan.core.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private ValidationUtils() {}

    /**
     * dateBirth format: yyyy-MM-dd
     * @param birthDay String format yyyy-MM-dd
     * @return true -> match
     */
    public static boolean birthDay(String birthDay) {
        var regex = "\\d{4}-1[0-2]|0\\d-[0-2]\\d|3[0-1]";
        var pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        var matcher = pattern.matcher(birthDay);
        return matcher.find();
    }
}
