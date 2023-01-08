package springboot_dev.day07.service;


import springboot_dev.day07.pojo.SMSCode;

public interface SMSCodeService {

    public  String sendCodeToSMS(String tele);

    public boolean check(SMSCode smsCode);
}
