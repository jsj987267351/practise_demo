//package springboot_dev.day05;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//@SpringBootTest
//public class SpringRedisTemplate {
//
////    与客户端相通  常用
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    void get(){
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        String name = ops.get("name");
//        System.out.println(name);
//    }
//}
