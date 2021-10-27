package com.codegym.emailJava.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    @Async
    public void send(String toEmail, String contentEmail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            messageHelper.setText(contentEmail, true);
            messageHelper.setFrom("c0421g1@gmail.com");
            messageHelper.setSubject("Confirm email From C0421G1");
            messageHelper.setTo(toEmail);
            mailSender.send(mimeMessage);
        }catch (MessagingException exception){
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public String buildEmail(String link){
        return "<h3 style=\"text-align: center\">Welcome</h3>\n" +
                "<p>C0421G1 xin gửi lời chào vì đã đăng ký trở thành một giáo viên ở Trường THPT Mầm Non</p>\n" +
                "<p>Hãy click vào link "+ link  +"  để active account của bạn</p>";
    }
}
