//package springboot_dev.day09.service.Impl;
//
////import com.alicp.jetcache.Cache;
////import com.alicp.jetcache.anno.CacheType;
////import com.alicp.jetcache.anno.CreateCache;
//import net.oschina.j2cache.CacheChannel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import springboot_dev.day09.pojo.SMSCode;
//import springboot_dev.day09.service.SMSCodeService;
//import springboot_dev.day09.utils.CodeUtils;
//
//import java.util.concurrent.TimeUnit;
//
////@Service
//public class SMSCodeServiceImpl implements SMSCodeService {
//
//    @Autowired
//    private CodeUtils codeUtils;
//
//
//    @Autowired
//    private CacheChannel cacheChannel;
//    @Override
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        cacheChannel.set("sms",tele,code);
//        return code;
//    }
//
//    @Override
//    public boolean check(SMSCode smsCode) {
//        String code = cacheChannel.get("sms",smsCode.getTele()).asString();
//        return smsCode.getCode().equals(code);
//    }
//
//
//}
