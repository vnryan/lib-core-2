package vn.edupiamath.googlesheetcore.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edupiamath.googlesheetcore.service.GoogleAuthenticationService;
import vn.edupiamath.googlesheetcore.service.GoogleSheetService;

@Configuration
public class GoogleSheetCoreConfig {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.google-sheet.credentials.file.path}")
    private String credentialsJsonPath;
    @Value("${spring.google-sheet.tokens.directory.path}")
    private String credentialFolder;

    @Bean
    public GoogleAuthenticationService getGoogleAuthenticationService() {
        return new GoogleAuthenticationService(credentialFolder, credentialsJsonPath);
    }

    @Bean
    public GoogleSheetService getGoogleSheetService(
            GoogleAuthenticationService authService
//            RateLimiter rateLimiter
    ) {
        return new GoogleSheetService(
                applicationName,
                authService
//                rateLimiter
        );
    }

//    @Bean
//    public RateLimiter getRateLimiter() {
//        return RateLimiter.create(2.0);
//    }
}
