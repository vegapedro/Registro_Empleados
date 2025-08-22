package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationCode(String to, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Código de Verificación para tu Cuenta");
        message.setText("Hola,\n\nGracias por registrarte. Tu código de verificación es: " + code + "\n\nEste código expirará en 24 horas.\n\nSaludos.");
        mailSender.send(message);
    }
}