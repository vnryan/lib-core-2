package vn.edupiamath.firebaseclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import vn.edupiamath.firebaseclient.services.FirebaseClient;
import vn.edupiamath.firebaseclient.services.impl.FirebaseClientImpl;
import vn.edupiamath.resttemplate.core.config.EnableRestTemplateCore;

@Configuration
@EnableRestTemplateCore
public class FirebaseClientConfig {

    @Bean
    public FirebaseClient getFirebaseService(
            RestTemplate restTemplate
    ) {
        return new FirebaseClientImpl(
                restTemplate
        );
    }

}
