package org.example.ej2.ejercicio1.mensajeria;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.example.ej2.ejercicio1.DataBase.ServicioEmail;

import java.util.Properties;

public class MailMessenger implements ServicioEmail {

    private static final String HOST  = "sandbox.smtp.mailtrap.io";
    private static final String PORT = "2525";
    private static final String USER = "b87e2abe360271";
    private static final String PASSWORD = "1e149bd54796d7";

    public MailMessenger(){

    }

    @Override
    public void update(String email) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(USER));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            mensaje.setSubject("INSCRIPCION");
            mensaje.setText("USTED YA HA SIDO INSCRIPTO AL CONCURSO");

            Transport.send(mensaje);
        }catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }

        System.out.println("Mensaje enviado Exitosamente");

    }

}
