package springboot_dev.day11;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_dev.day11.service.SendMailService;

@SpringBootTest
public class MailTest {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void Test(){
        sendMailService.sendMail();
    }
}
