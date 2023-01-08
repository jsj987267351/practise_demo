//package springboot_dev.day05;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//@SpringBootTest
//public class RedisTest {
//
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    void set(){
//        ValueOperations ops = redisTemplate.opsForValue();
//        ops.set("name","zcz");
//    }
//
//    @Test
//    void get(){
//        ValueOperations ops = redisTemplate.opsForValue();
//        Object name = ops.get("name");
//        System.out.println(name);
//    }
//
//    @Test
//    void hset(){
//        HashOperations ops = redisTemplate.opsForHash();
//        ops.put("info","name","zcz");
//    }
//
//    @Test
//    void hget(){
//        HashOperations ops = redisTemplate.opsForHash();
//        Object val = ops.get("info", "name");
//        System.out.println(val);
//    }
//}
