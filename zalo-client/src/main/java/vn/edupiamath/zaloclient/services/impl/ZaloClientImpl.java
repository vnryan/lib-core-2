package vn.edupiamath.zaloclient.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import retrofit2.Call;
import retrofit2.Response;
import vn.edupiamath.core.constants.AppConstants;
import vn.edupiamath.core.model.zalo.Message;
import vn.edupiamath.core.model.zalo.Recipient;
import vn.edupiamath.core.model.zalo.ZaloResponse;
import vn.edupiamath.core.utils.ConvertUtils;
import vn.edupiamath.core.utils.StringUtils;
import vn.edupiamath.tokencore.service.ZaloTokenService;
import vn.edupiamath.zaloclient.services.CallAuthZaloClient;
import vn.edupiamath.zaloclient.services.ZaloClient;

import java.net.URI;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZaloClientImpl implements ZaloClient {

    @Value("${spring.zalo.app-id}")
    private String appId;
    @Value("${spring.zalo.oa-id}")
    private String oaId;
    @Value("${spring.zalo.auth-code}")
    private String authCode;

    @Value("${spring.zalo.base-url-oauth}")
    private String zaloBaseUrlOauth;
    @Value("${spring.zalo.base-url-api}")
    private String zaloBaseUrlApi;
    @Value("${spring.zalo.secret-key}")
    private String zaloSecretKey;

    @Value("${spring.zalo.path.permission:/v4/oa/permission}")
    private String permissionPath;
    @Value("${spring.zalo.path.access-token:/v4/oa/access_token}")
    private String accessTokenPath;

    @Value("${spring.zalo.path.message:/v2.0/oa/message}")
    private String messagePath;
    @Value("${spring.zalo.path.get-profile:/v2.0/oa/getprofile}")
    private String getProfilePath;

    private final RestTemplate restTemplate;
    private final ZaloTokenService zaloTokenService;
    private final CallAuthZaloClient callAuthZaloClient;

    @Override
    public ZaloResponse getProfile(String zaloUserId) {
        var token = zaloTokenService.getToken();
        if (token == null) {
            //update new token
            var tokenResponse = accessToken(authCode);
            var tokenMap = ConvertUtils.toObject(tokenResponse, Map.class);
            var tokenCheck = tokenMap.get("access_token");
            if (tokenCheck != null) {
                token = tokenCheck.toString();
                zaloTokenService.updateToken(
                        token,
                        tokenMap.get("refresh_token").toString(),
                        Integer.parseInt(tokenMap.get("expires_in").toString())
                );
            }

        }

        var response = getProfile(zaloUserId, token);
        if (response.getError() == -216) {
            //refresh token
            var refreshToken = zaloTokenService.getRefreshToken();
            if (refreshToken != null) {
                var tokenResponse = refreshToken(refreshToken);
                var tokenMap = ConvertUtils.toObject(tokenResponse, Map.class);
                var tokenCheck = tokenMap.get("access_token");
                if (tokenCheck != null) {
                    token = tokenCheck.toString();
                    zaloTokenService.updateToken(
                            token,
                            tokenMap.get("refresh_token").toString(),
                            Integer.parseInt(tokenMap.get("expires_in").toString())
                    );
                }
            }
            return getProfile(zaloUserId, token);
        }
        return response;
    }

    public ZaloResponse getProfile(String zaloUserId, String token) {
        var url = zaloBaseUrlApi + getProfilePath;
        log.info("(getProfile) url: {}, zaloUserId: {}",
                url, zaloUserId);
        Map<String, Object> params = new HashMap<>();
        Map<String, String> userId = new HashMap<>();
        userId.put("user_id", zaloUserId);
        params.put("data", userId);
        var header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add(AppConstants.ACCESS_TOKEN_ZALO, token);
        return ConvertUtils.toObject(get(url, header, params), ZaloResponse.class);
    }

    /**
     * https://oauth.zaloapp.com/v4/oa/permission?
     * app_id=853777273869636140
     * &redirect_uri=https%3A%2F%2Fapi.edupiamath.vn%2Fmath%2Fzalo%2Fcall-back
     *
     * @return
     */
    @Override
    public ZaloResponse getPermission() {
        return null;
    }

    /**
     * https://oauth.zaloapp.com/v4/oa/permission?
     * app_id=853777273869636140
     * &redirect_uri=https%3A%2F%2Fapi.edupiamath.vn%2Fmath%2Fzalo%2Fcall-back
     *
     * @param oaId String
     * @param code String
     * @return
     */
    @Override
    public Object callBack(String oaId, String code) {
        return accessToken(code);
    }

    @Override
    public Object accessToken(String code) {
        log.info("(accessToken) appId: {}, code: {}",
                appId, code);
        Call<Object> call = callAuthZaloClient.getAccessTokenRetrofit(
                AppConstants.AUTHORIZATION_CODE_ZALO,
                appId,
                code,
                zaloSecretKey
        );
        try {
            Response<Object> response = call.execute();
            var tokenResponse = response.body();

            var tokenMap = ConvertUtils.toObject(tokenResponse, Map.class);
            var tokenCheck = tokenMap.get("access_token");
            if (tokenCheck != null) {
                zaloTokenService.updateToken(
                        tokenMap.get("access_token").toString(),
                        tokenMap.get("refresh_token").toString(),
                        Integer.parseInt(tokenMap.get("expires_in").toString())
                );
            }
            return tokenResponse;
        } catch (Exception ex) {
            log.error("(accessToken): ex: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public Object refreshToken(String refreshToken) {
        log.info("(refreshToken) appId: {}, refresh token: {}",
                appId,
                refreshToken);
        Call<Object> call = callAuthZaloClient.getRefreshTokenRetrofit(
                AppConstants.REFRESH_TOKEN_ZALO,
                appId,
                refreshToken,
                zaloSecretKey
        );
        try {
            Response<Object> response = call.execute();
            var tokenResponse = response.body();
            var tokenMap = ConvertUtils.toObject(tokenResponse, Map.class);
            var tokenCheck = tokenMap.get("access_token");
            if (tokenCheck != null) {
                zaloTokenService.updateToken(
                        tokenCheck.toString(),
                        tokenMap.get("refresh_token").toString(),
                        Integer.parseInt(tokenMap.get("expires_in").toString())
                );
            }
            return tokenResponse;
        } catch (Exception ex) {
            log.error("(refreshToken): ex: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public Object refreshToken() {
        return refreshToken(zaloTokenService.getRefreshToken());
    }

    @Override
    public Object getAccessToken() {
        return accessToken(authCode);
    }

    /**
     * curl \
     * -X POST \
     * -H "Content-Type: application/json" \
     * -H 'access_token: <your_access_token>' \
     * -d '{
     * "recipient":{
     * "user_id":"2512523625412515"
     * },
     * "message":{
     * "text":"hello, world!"
     * }
     * }' "https://openapi.zalo.me/v2.0/oa/message"
     *
     * @return Object
     */
    @Override
    public ZaloResponse sendMessage(String zaloUserId, String message) {
        var token = zaloTokenService.getToken();
        if (token == null) {
            //update new token
            accessToken(authCode);
            token = zaloTokenService.getToken();
        }

        var response = sendMessage(zaloUserId, message, token);
        if (response.getError() == -216) {
            //refresh token
            var refreshToken = zaloTokenService.getRefreshToken();
            if (refreshToken != null) {
                refreshToken(refreshToken);
                token = zaloTokenService.getToken();
            }
            return sendMessage(zaloUserId, message, token);
        }
        return response;
    }

    @Override
    public ZaloResponse sendMessage(String zaloUserId, String message, String token) {
        var url = zaloBaseUrlApi + messagePath;
        log.info("(sendMessage) url: {}, zaloUserId: {}, message: {}",
                url, zaloUserId, message);
        Map<String, Object> dataMessage = new HashMap<>();
        Recipient recipient = new Recipient();
        recipient.setUserId(zaloUserId);
        Message zaloMessage = new Message();
        zaloMessage.setText(message);
        dataMessage.put("recipient", recipient);
        dataMessage.put("message", zaloMessage);
        var header = new HttpHeaders();
        header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        header.add(AppConstants.ACCESS_TOKEN_ZALO, token);
        return ConvertUtils.toObject(post(url, header, dataMessage), ZaloResponse.class);
    }

    @Override
    public Object post(String url, HttpHeaders httpHeaders, Object data) {
        log.info("(post) url: {}, data: {}", url, data);
        HttpEntity<Object> entity = new HttpEntity<>(data, httpHeaders);
        log.info("(post) entity: {}", entity);
        var response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
        log.info("(post) response: {}", response.getBody());
        return response.getBody();
    }

    @Override
    public Object get(String url, HttpHeaders httpHeaders, Map<String, Object> params) {
        if (params != null) {
            url = url + "?" + StringUtils.buildParam(params);
        }
        URI uri = UriComponentsBuilder.fromUriString(url).build().encode().toUri();
        log.info("(get) uri: {}, params: {}",
                uri, params);
        HttpEntity<Object> entity = new HttpEntity<>(null, httpHeaders);
        var response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                Object.class
        );
        log.info("(get) response: {}",
                response.getBody());
        return response.getBody();
    }
}
