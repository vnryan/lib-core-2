package vn.edupiamath.zaloclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import vn.edupiamath.resttemplate.core.config.EnableRestTemplateCore;
import vn.edupiamath.retrofit.configuration.RetrofitCoreConfig;
import vn.edupiamath.tokencore.config.EnableTokenCore;
import vn.edupiamath.tokencore.service.ZaloTokenService;
import vn.edupiamath.zaloclient.services.CallAuthZaloClient;
import vn.edupiamath.zaloclient.services.ZaloClient;
import vn.edupiamath.zaloclient.services.impl.ZaloClientImpl;

@Configuration
@EnableRestTemplateCore
@EnableTokenCore
public class ZaloClientConfig {

    @Value("${spring.zalo.base-url-oauth}")
    private String zaloBaseUrlOauth;

    @Value("${spring.zalo.base-url-oauth.headers:HEADERS}")
    private String logLevel;

    @Bean
    public ZaloClient getZaloService(
            RestTemplate restTemplate,
            ZaloTokenService zaloTokenService,
            CallAuthZaloClient callAuthZaloClient
    ) {
        return new ZaloClientImpl(
                restTemplate,
                zaloTokenService,
                callAuthZaloClient
        );
    }

    @Bean
    public CallAuthZaloClient getCallAuthZaloClient() {
        return RetrofitCoreConfig.create(
                zaloBaseUrlOauth, CallAuthZaloClient.class, logLevel
        );
    }
}
