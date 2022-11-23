package co.edu.uniquindio.proyecto.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    public boolean enviarEmail(String asunto, String contenido, String destinatario) {
        return false;
    }

}
