package springboot_dev.day09.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_dev.day09.pojo.SMSCode;
import springboot_dev.day09.service.SMSCodeService;

//@RestController
//@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService service;


    @GetMapping
    public String getCode(String tele) {
        return service.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode) {
        return service.check(smsCode);
    }
}
