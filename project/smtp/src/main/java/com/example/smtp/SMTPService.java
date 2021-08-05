package com.example.smtp;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class SMTPService {
  public void send() throws Exception {

    Properties prop = System.getProperties();
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.port", "587");

    Session session = Session.getDefaultInstance(prop, new Authenticator(){
      @Override
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("sunnyprk2@gmail.com", "sunapark");
      }
    });

    MimeMessage message = new MimeMessage(session);

    message.setSentDate(new Date());
    message.setFrom(new InternetAddress("sunnyprk2@gmail.com", "박선아"));
    message.setRecipient(
        Message.RecipientType.TO, new InternetAddress("sunnyprk38@gmail.com", "sunny park"));
    message.setSubject("메일 테스트", "UTF-8");
    message.setText("안녕하세요 테스트 메일입니다.", "UTF-8");

    Transport.send(message);

  }
}
