package springboot_dev.day09.service;


import springboot_dev.day09.pojo.SMSCode;

public interface SMSCodeService {

    public  String sendCodeToSMS(String tele);

    public boolean check(SMSCode smsCode);
}
