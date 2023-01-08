package springboot_dev.day08.service;


import springboot_dev.day08.pojo.SMSCode;

public interface SMSCodeService {

    public  String sendCodeToSMS(String tele);

    public boolean check(SMSCode smsCode);
}
