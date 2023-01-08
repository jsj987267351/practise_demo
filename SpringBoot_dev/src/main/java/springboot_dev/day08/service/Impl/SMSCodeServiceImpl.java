//package springboot_dev.day08.service.Impl;
//
//import com.alicp.jetcache.Cache;
//import com.alicp.jetcache.anno.CacheType;
//import com.alicp.jetcache.anno.CreateCache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import springboot_dev.day08.pojo.SMSCode;
//import springboot_dev.day08.service.SMSCodeService;
//import springboot_dev.day08.utils.CodeUtils;
//
//import java.util.concurrent.TimeUnit;
//
////@Service
//public class SMSCodeServiceImpl implements SMSCodeService {
//
//    @Autowired
//    private CodeUtils codeUtils;
//
////   以下为remote    jetCache 自定义缓存   expire默认为秒  area为yml中选择的缓存空间  最终key为 area_name_tele
////    @CreateCache(area = "sms",name = "jetCache_",expire = 3600,timeUnit = TimeUnit.SECONDS)
////    private Cache<String, String> jetCache;
//
////    以下为local    cacheType选择使用本地还是远程缓存
//    @CreateCache(name = "jetCache_",expire = 3600,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
//    private Cache<String, String> jetCache;
//
//    @Override
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        jetCache.put(tele,code);
//        return code;
//    }
//
//    @Override
//    public boolean check(SMSCode smsCode) {
//        String code = jetCache.get(smsCode.getTele());
//        return smsCode.getCode().equals(code);
//    }
//
//
//}
