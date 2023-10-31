package vn.ryan.token.core.service;

import vn.ryan.core.model.zalo.ZaloToken;

public interface ZaloTokenService {
    String getToken();
    String getRefreshToken();
    ZaloToken updateToken(
            String token,
            String refreshToken,
            Integer expireIn
    );
}
