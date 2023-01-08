//package springboot_dev.day11.service.Impl;
//
//import javafx.scene.shape.HLineTo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import springboot_dev.day11.service.SendMailService;
//
//import javax.mail.Header;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
////@Service
//public class SendMailServiceImpl2 implements SendMailService {
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
//
//        try {
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message,true);   //设置true后即可发送附件
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(context,true);   //设置true后即可在正文中加入html语言，会自动解析，直接卸载”“中
//
////            发送附件
//            File file = new File("E:\\java\\敲\\server.log");
//            helper.addAttachment("文件名",file);
//
//            javaMailSender.send(message);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
