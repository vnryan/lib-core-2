package vn.ryan.token.core.service;

import vn.ryan.core.model.Token;

public interface TokenService {

    Token generateToken(
            Long userId,
            String accessUser,
            String generalToken,
            String refreshToken,
            String deviceId,
            String deviceType
    );

//    Token getToken(
//            String accessToken
//    );

    Token getTokenByGeneral(
            String accessUser,
            String accessToken
    );

    Token getTokenByGeneral(
            String accessToken
    );

    Token refreshToken(
            String accessUser,
            String token,
            String refreshToken
    );

    void removeToken(
            String accessUser, String generalToken
    );
}
