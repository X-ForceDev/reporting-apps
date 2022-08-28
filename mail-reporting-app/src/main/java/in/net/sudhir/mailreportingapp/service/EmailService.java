package in.net.sudhir.mailreportingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/***
 Package Name: in.net.sudhir.mailreportingapp.service
 User Name: SUDHIR
 Created Date: 28-08-2022 at 07:35
 Description:
 */
@Component
public class EmailService{

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Environment environment;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bsudhir6@gmail.com");
        message.setTo("sudhir@sudhir.net.in");
        message.setSubject("spring boot subject");
        message.setText("springboot body");
        emailSender.send(message);
    }

    public void sendStatisticsReport(String report) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(report, true);
        helper.setTo(environment.getProperty("statistics.reporting.send.to"));
        helper.setSubject(environment.getProperty("statistics.reporting.send.subject"));
        helper.setFrom(environment.getProperty("statistics.reporting.send.from"));
        emailSender.send(mimeMessage);
    }
}
