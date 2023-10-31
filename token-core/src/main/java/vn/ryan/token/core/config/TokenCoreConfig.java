package vn.ryan.token.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.ryan.redis.core.config.EnableRedisClusterCore;
import vn.ryan.token.core.service.*;

@EntityScan("vn.edupiamath.entitycore")
@Configuration
//@EnableServiceCore
@EnableRedisClusterCore
@EnableScheduling
public class TokenCoreConfig {

    @Bean
    public TokenService getTokenService(
            RedisTemplate<String, Object> redisTemplate
    ) {
        return new TokenServiceImpl(redisTemplate);
    }

    @Bean
    public AccessKeyService getAccessKeyService(
            RedisTemplate<String, Object> redisTemplate
    ) {
        return new AccessKeyServiceImpl(redisTemplate);
    }

    @Bean
    public ZaloTokenService getZaloTokenService(
            RedisTemplate<String, Object> redisTemplate
    ) {
        return new ZaloTokenServiceImpl(redisTemplate);
    }
}
