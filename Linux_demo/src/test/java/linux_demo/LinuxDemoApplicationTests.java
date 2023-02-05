package linux_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class LinuxDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 使用Jedis操作Redis
     */
    @Test
    public void testRedis(){
//        1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
//        2.执行操作
        jedis.set("username","xiaoming");
        String value = jedis.get("username");
        System.out.println(value);
//        jedis.del("username");
        jedis.hset("myhash","addr","xuzhou");
        String hash = jedis.hget("myhash", "addr");
        System.out.println(hash);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
//        3.关闭连接
        jedis.close();
    }

    /**
     * 操作String类型数据
     */
    @Test
    public void testString(){
       redisTemplate.opsForValue().set("city","xuzhou");
        System.out.println(redisTemplate.opsForValue().get("city"));
        redisTemplate.opsForValue().set("key1","value1",10L, TimeUnit.SECONDS);

        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("city", "nanjing");
        System.out.println(aBoolean);
    }

    /**
     * 操作hash类型
     */
    @Test
    public void testHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
//        存值
        hashOperations.put("001","name","zcz");
        hashOperations.put("001","age","24");
//取值
        String name = (String) hashOperations.get("001", "name");
        System.out.println(name);
//        获取keys
        Set keys = hashOperations.keys("001");
        for (Object key : keys) {
            System.out.println(key);
        }
//        获取values
        List values = hashOperations.values("001");
        for (Object value : values) {
            System.out.println(value);
        }
    }

    /**
     * 操作list
     *
     */
    @Test
    public void testList(){
        ListOperations listOperations = redisTemplate.opsForList();
//        存值
        listOperations.leftPush("mylist","a");
        listOperations.leftPushAll("mylist","b","c");

//        取值
        List<String> mylist = listOperations.range("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }
//        获得列表长度
        Long size = listOperations.size("mylist");
//        出队列
        int lSzie = size.intValue();
        for (int i = 0; i < lSzie; i++) {
           String pop = (String) listOperations.rightPop("mylist");
            System.out.println(pop);
        }
    }

    /**
     * 操作set
     *
     */
    @Test
    public void testSet(){
        SetOperations setOperations = redisTemplate.opsForSet();
//        存值
        setOperations.add("myset","a","b","c","a");
//        取值
        Set<String> myset = setOperations.members("myset");
        for (String s : myset) {
            System.out.println(s);
        }
//        删除成员
        setOperations.remove("myset","a","b");
        myset = setOperations.members("myset");
        for (String s : myset) {
            System.out.println(s);
        }
    }

    /**
     * Zset  分数从小到大排序
     */

    @Test
    public void testZset(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        存值
        zSetOperations.add("myzset","a",10.0);
        zSetOperations.add("myzset","b",11.0);
        zSetOperations.add("myzset","c",12.0);
        zSetOperations.add("myzset","a",13.0);
//        取值
        Set <String>myzset = zSetOperations.range("myzset", 0, -1);
        for (String s : myzset) {
            System.out.println(s);
        }
//        修改分数
        zSetOperations.incrementScore("myzset","b",20);
        myzset = zSetOperations.range("myzset", 0, -1);
        for (String s : myzset) {
            System.out.println(s);
        }
//        删除成员
        zSetOperations.remove("myzset","a","b");
        myzset = zSetOperations.range("myzset", 0, -1);
        for (String s : myzset) {
            System.out.println(s);
        }
    }

    /**
     * 通用操作，针对不同数据都可以操作
     */
    @Test
    public void testCommon(){
//        获取Redis中所有的key
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
//        判断某个key是否存在
        Boolean username = redisTemplate.hasKey("username");
        System.out.println(username);
//        删除指定key
        redisTemplate.delete("001");
//        获取指定key对应的value数据类型
        DataType myset = redisTemplate.type("myset");
        System.out.println(myset.name());

    }
}
