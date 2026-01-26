package swd_sentify.back_end.Service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendVerificationEmail(String email, String name, String code) throws MessagingException;
}
