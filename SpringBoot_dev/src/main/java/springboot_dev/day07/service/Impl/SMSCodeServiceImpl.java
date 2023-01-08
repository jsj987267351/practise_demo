//package springboot_dev.day07.service.Impl;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//import net.rubyeye.xmemcached.XMemcachedClient;
//import net.rubyeye.xmemcached.exception.MemcachedException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//import springboot_dev.day07.config.XMemcachedConfig;
//import springboot_dev.day07.pojo.SMSCode;
//import springboot_dev.day07.service.SMSCodeService;
//import springboot_dev.day07.utils.CodeUtils;
//
//import java.util.concurrent.TimeoutException;
//
////@Service
//public class SMSCodeServiceImpl implements SMSCodeService {
//
//    @Autowired
//    private CodeUtils codeUtils;
//
//    @Autowired
//    private MemcachedClient memcachedClient;
//
////    @Override
////    @CachePut(value = "smsCode",key = "#tele")   //只放不取
////    public String sendCodeToSMS(String tele) {
////       return codeUtils.generator(tele);
////    }
////
////    @Override
////    public boolean check(SMSCode smsCode) {
////        String code = smsCode.getCode();
////        String cacheCode= codeUtils.get(smsCode.getTele());
////        return code.equals(cacheCode);
////    }
//
////   以下为 memcached
//    @Override
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        try {
//            memcachedClient.set(tele,10,code);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return code;
//    }
//
//    @Override
//    public boolean check(SMSCode smsCode) {
//        String code = null;
//        try {
//            code = memcachedClient.get(smsCode.getTele()).toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return smsCode.getCode().equals(code);
//    }
//
//
//}
