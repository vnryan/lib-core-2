package vn.edupiamath.mailservicecore.services;

public interface MailService {
    void send(String to, String subject, String text);
    void send(String[] to, String subject, String text);
}
