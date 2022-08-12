package json;

import com.alibaba.fastjson.JSON;

public class Fastjsondemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String s = JSON.toJSONString(user);
        System.out.println(s);

        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(user1);

    }
}
