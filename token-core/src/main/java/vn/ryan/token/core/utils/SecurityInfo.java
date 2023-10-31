package vn.ryan.token.core.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import vn.ryan.core.model.Token;
import vn.ryan.core.utils.ConvertUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SecurityInfo {

    public static String getUserName() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) return null;
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return "anonymousUser".equals(user) ? null : user;
    }

    public static String getGeneralToken() {
        var token = getToken();
        return token == null ? null : token.getGeneralToken();
    }

    public static Long getUserId() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getUserId();
    }

    public static String getMathToken() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getMathToken();
    }

    public static String getRefreshToken() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getRefreshToken();
    }

    public static Integer getExpire() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getExpire();
    }

    public static String getDeviceId() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getDeviceId();
    }

    public static String getDeviceType() {
        var token = getToken();
        if (token == null)
            return null;
        return token.getDeviceType();
    }

    private static List<String> getRoles() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

    private static Token getToken() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        var tokenObject = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return ConvertUtils.toObject(tokenObject, Token.class);
    }
}
