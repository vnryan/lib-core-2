package vn.ryan.token.core.utils;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    private TokenUtils() {}

    public static String getToken(HttpServletRequest request) {
        return request.getHeader("access_token");
    }

    public static String getAccessUser(HttpServletRequest request) {
        var accessUser = request.getHeader("access_user");
        return accessUser == null || "".equals(accessUser) ? null : accessUser.toLowerCase();
    }
}
