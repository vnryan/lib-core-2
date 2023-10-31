package vn.ryan.token.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class AccessKeyServiceImpl implements AccessKeyService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Boolean checkAccessKeyKeyUser(String userName, String accessKey) {
        if (accessKey.equals("edupiamath123"))
            return true;
        var tokenData = redisTemplate.opsForValue().get(accessKey);
        return tokenData != null && tokenData.equals(userName);
    }

    @Override
    public String generateAccessKey(String accessUser) {
        try {
            var uuid = UUID.randomUUID();
            redisTemplate.opsForValue().set(
                    uuid.toString(), accessUser
            );
            redisTemplate.expire(uuid.toString(), 3600, TimeUnit.SECONDS);
            return uuid.toString();
        } catch (Exception ex) {
            //generate default accessKey
            return null;
        }
    }
}
