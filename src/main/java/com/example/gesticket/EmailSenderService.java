package com.example.gesticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("diarraatoucarter7655@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);


        System.out.println("Email envoyé avec succèsss!!!");
    }
}
