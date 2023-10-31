package vn.edupiamath.mailservicecore.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import vn.edupiamath.mailservicecore.services.MailService;

@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.from:}")
    private String from;
    @Value("${spring.mail.enable:false}")
    private Boolean isSender;

    private final MailSender mailSender;

    @Override
    public void send(String to, String subject, String text) {
        if (isSender) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        }
    }

    @Override
    public void send(String[] to, String subject, String text) {
        if (isSender) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        }
    }
}
