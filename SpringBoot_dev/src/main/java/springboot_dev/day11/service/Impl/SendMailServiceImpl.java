//package springboot_dev.day11.service.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import springboot_dev.day11.service.SendMailService;
//
////@Service
//public class SendMailServiceImpl implements SendMailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    //    发送人
//    private String from = "987267351@qq.com";
//    //    接收人
//    private String to = "jsj987267351@163.com";
//    //    标题
//    private String subject = "测试邮件";
//    //    正文
//    private String context = "正文";
//
//    @Override
//    public void sendMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from + "(显示名称)");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(context);
//        javaMailSender.send(message);
//    }
//}
