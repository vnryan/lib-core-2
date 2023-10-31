package vn.ryan.token.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import vn.ryan.core.constants.RedisKeyEducaMath;
import vn.ryan.core.model.zalo.ZaloToken;
import vn.ryan.core.utils.ConvertUtils;

import static vn.ryan.core.utils.AppUtils.getFullStackTrace;

@Slf4j
@RequiredArgsConstructor
public class ZaloTokenServiceImpl implements ZaloTokenService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getToken() {
        try {
            var tokenData = redisTemplate.opsForValue().get(
                    RedisKeyEducaMath.REDIS_KEY_EDUCA_MATH_ZALO_TOKEN.name()
            );
            var token = ConvertUtils.toObject(tokenData, ZaloToken.class);
            if (token == null) {
                log.warn("(getToken) ===> No token in services");
                return null;
            }
            return token.getAccessToken();
            //end new
        } catch (Exception ex) {
            log.warn("(getToken) redis error: {}", getFullStackTrace(ex));
            return null;
        }
    }

    @Override
    public String getRefreshToken() {
        try {
            var tokenData = redisTemplate.opsForValue().get(
                    RedisKeyEducaMath.REDIS_KEY_EDUCA_MATH_ZALO_TOKEN.name()
            );
            var token = ConvertUtils.toObject(tokenData, ZaloToken.class);
            if (token == null) {
                log.warn("(getRefreshToken) ===> No token in services");
                return null;
            }
            return token.getRefreshToken();
            //end new
        } catch (Exception ex) {
            log.warn("(getRefreshToken) redis error: {}", getFullStackTrace(ex));
            return null;
        }
    }

    @Override
    public ZaloToken updateToken(
            String token,
            String refreshToken,
            Integer expireIn
    ) {
        try {
            if (token == null || refreshToken == null) {
                log.warn("(updateToken) ===> No Token update");
                return null;
            }
            var zaloToken = new ZaloToken();
            zaloToken.setAccessToken(token);
            zaloToken.setRefreshToken(refreshToken);
            zaloToken.setExpiresIn(expireIn);
            redisTemplate.opsForValue().set(
                    RedisKeyEducaMath.REDIS_KEY_EDUCA_MATH_ZALO_TOKEN.name(), zaloToken
            );

            return zaloToken;
            //end new
        } catch (Exception ex) {
            log.warn("(updateToken) redis error: {}", getFullStackTrace(ex));
            return null;
        }
    }

}
