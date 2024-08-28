package tech.pedrolima.DoacaoDePlantas.utils;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EnvioEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public void imprimir(String email){
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);

        String assunto = "Redefinição de senha";

        String mensagem = "Este é o seu código de redefinição de senha\n" +
                randomNumber;

        //Código de envio de emails, com Spring boot
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            System.out.println("Email enviado");
        }catch (Exception e){
            System.out.println("Erro ao enviar");
        }

        System.out.println(email);
        System.out.println(randomNumber);
    }

}
