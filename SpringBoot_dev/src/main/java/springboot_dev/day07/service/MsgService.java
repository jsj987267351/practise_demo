package springboot_dev.day07.service;

public interface MsgService {

    public String get(String tel);

    public boolean check(String tel , String code);
}
