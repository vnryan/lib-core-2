package vn.ryan.token.core.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import vn.ryan.core.model.Token;
import vn.ryan.core.utils.ConvertUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static vn.ryan.core.utils.AppUtils.getFullStackTrace;

@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.security.jwt.expiration:#{24*60*60}}")
    private int expiration;
    @Value("${spring.security.jwt.secret:RWR1cGlhTWF0aFNlY3JldEtleQ==}")
    private String secret;

    public Token generateToken(
            Long userId,
            String accessUser,
            String generalToken,
            String refreshToken,
            String deviceId,
            String deviceType
    ) {
        log.info("(generateToken) accessUser: {}", accessUser);
        accessUser = accessUser.toLowerCase();
        var token = new Token();
        token.setUserId(userId);
        token.setUserName(accessUser);
        token.setGeneralToken(generalToken);
        token.setRefreshToken(refreshToken);
        token.setExpire(expiration);
        token.setMathToken(generateToken(userId, accessUser));
        token.setDeviceId(deviceId);
        token.setDeviceType(deviceType);
        log.info("(generateToken) update token redis accessUser: {}", accessUser);
        redisTemplate.opsForValue().set(
                generalToken, token
        );
        redisTemplate.expire(generalToken, expiration, TimeUnit.SECONDS);
        return token;
    }

    public String generateToken(
            String accessUser
    ) {
        log.info("(generateToken) accessUser: {}", accessUser);
        Instant now = Instant.now();
        accessUser = accessUser.toLowerCase();
        return Jwts.builder()
                .claim("userName", accessUser)
                .setSubject(accessUser)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(expiration, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
    }

    public String generateToken(
            Long userId,
            String accessUser
    ) {
        log.info("(generateToken) accessUser: {}", accessUser);
        Instant now = Instant.now();
        accessUser = accessUser.toLowerCase();
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        return Jwts.builder()
                .claim("userName", accessUser)
                .claim("userId", userId)
                .claim("authorities", roles)
                .setSubject(accessUser)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(expiration, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
    }

//    @Override
//    public Token getToken(
//            String accessToken
//    ) {
//        try {
//            var data = redisTemplate.opsForHash().entries(
//                    RedisKeyEducaMath.REDIS_KEY_EDUCA_MATH_TOKEN_USERNAME.name()
//            );
//            var tokenData = data.get(accessUser);
//            var token = ConvertUtils.toObject(tokenData, Token.class);
//            if (accessToken != null && accessToken.equals(token.getMathToken())) {
//                return token;
//            } else {
//                return null;
//            }
//        } catch (Exception ex) {
//            log.warn("(getUnit) redis error: {}", getFullStackTrace(ex));
//            return null;
//        }
//    }

    @Override
    public Token getTokenByGeneral(
            String accessUser,
            String generalToken
    ) {
        try {
            if (accessUser == null || generalToken == null) {
                log.warn("(getTokenByGeneral) ===> No header access_user or access_token");
                return null;
            }
            var tokenData = redisTemplate.opsForValue().get(
                    accessUser.toLowerCase() + "-" + generalToken
            );
            if (tokenData == null) {
                log.warn("(getTokenByGeneral) ===> No token in services");
                return null;
            }
            return ConvertUtils.toObject(tokenData, Token.class);
            //end new
        } catch (Exception ex) {
            log.warn("(getTokenByGeneral) redis error: {}", getFullStackTrace(ex));
            return null;
        }
    }

    @Override
    public Token getTokenByGeneral(
            String generalToken
    ) {
        try {
            if (generalToken == null) {
                log.warn("(getTokenByGeneral) ===> No header access_user or access_token");
                return null;
            }
            var tokenData = redisTemplate.opsForValue().get(generalToken);
            if (tokenData == null) {
                log.warn("(getTokenByGeneral) ===> No token in services");
                return null;
            }
            return ConvertUtils.toObject(tokenData, Token.class);
        } catch (Exception ex) {
            log.warn("(getTokenByGeneral) redis error: {}", getFullStackTrace(ex));
            return null;
        }
    }

    public Token refreshToken(
            String accessUser,
            String token,
            String refreshToken
    ) {
        return null;
    }

    @Override
    public void removeToken(String accessUser, String generalToken) {
        log.warn("(removeToken) userName: {} ===> Remove token", accessUser);
        redisTemplate.delete(generalToken);
    }
}
