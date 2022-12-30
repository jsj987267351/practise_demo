package springboot_dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.validation.annotation.Validated;
import springboot_dev.day03.config.MsgConfig;
import springboot_dev.day03.pojo.BookCase;


//添加临时属性，并且临时属性会覆盖yml中的数据   优先级：args>properties>yml
//@SpringBootTest(properties = {"test.prop=testValue2"})
//@SpringBootTest(args = {"--test.prop=testValue3"})
@SpringBootTest
//导入测试中定义的bean，临时使用
@Import(MsgConfig.class)
class SpringBootDevApplicationTests {

//day02
//    @Value("${datasource.password}")
//    private String password;

//    @Value("${test.prop}")
//    private String msg;

//    @Autowired
//    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void contextLoads() {
//        System.out.println(password);

//        day03
//        System.out.println(msg);

//        System.out.println(msg);
        System.out.println(bookCase);

    }

}
