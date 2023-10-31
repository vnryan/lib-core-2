package vn.edupiamath.zaloclient.services;

import org.springframework.http.HttpHeaders;
import vn.edupiamath.core.model.zalo.ZaloResponse;

import java.util.Map;

public interface ZaloClient {
     ZaloResponse getProfile(String zaloUserId);
     ZaloResponse getProfile(String zaloUserId, String token);
     Object getPermission();
     Object callBack(String oaId, String code);
     Object accessToken(String code);
     Object refreshToken(String refreshToken);
     Object refreshToken();
     Object getAccessToken();
     ZaloResponse sendMessage(String zaloUserId, String message);
     ZaloResponse sendMessage(String zaloUserId, String message, String token);
     Object post(String url, HttpHeaders httpHeaders, Object data);
     Object get(String url, HttpHeaders httpHeaders, Map<String, Object> params);
}
