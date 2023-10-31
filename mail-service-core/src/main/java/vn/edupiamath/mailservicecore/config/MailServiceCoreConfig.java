package vn.edupiamath.mailservicecore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import vn.edupiamath.mailservicecore.services.MailService;
import vn.edupiamath.mailservicecore.services.impl.MailServiceImpl;

import java.util.Properties;

@Configuration
public class MailServiceCoreConfig {

    @Value("${spring.mail.username:}")
    private String username;
    @Value("${spring.mail.password:}")
    private String password;
    @Value("${spring.mail.host:smtp.gmail.com}")
    private String host;
    @Value("${spring.mail.port:587}")
    private Integer port;
    @Value("${spring.mail.transport.protocol:smtp}")
    private String transport;
    @Value("${spring.mail.smtp.auth:true}")
    private String smtpAuth;
    @Value("${spring.mail.smtp.starttls.enable:true}")
    private String smtpStarttls;
    @Value("${spring.mail.debug:true}")
    private String debug;

    @Bean
    public MailService getEmailService(
            MailSender mailSender
    ) {
        return new MailServiceImpl(mailSender);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", transport);
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", smtpStarttls);
        props.put("mail.debug", debug);

        return mailSender;
    }
}
