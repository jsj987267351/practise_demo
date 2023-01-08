package springboot_dev.day07.service.Impl;

import org.springframework.stereotype.Service;
import springboot_dev.day07.service.MsgService;

import java.util.HashMap;

//@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String,String> cache = new HashMap<String ,String>();

    @Override
    public String get(String tel) {
        String code = tel.substring(tel.length() - 6);
        cache.put(tel,code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        String queryCode = cache.get(tel);
        return code.equals(queryCode);
    }
}
