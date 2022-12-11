package springboot_basis.day02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_basis.day02.pojo.MyDateSource;

//Rest 模式
//@RestController
//@RequestMapping("/books")
public class BookController {

//    读取yml单一数据
    @Value("${country}")
    private String country;

    @Value("${user23.name}")
    private String name;

    @Value("${likes[2]}")
    private String like;

    @Value("${user6[0].age}")
    private String age;

//    封装到类
    @Autowired
    private MyDateSource myDateSource;

//   读取全部数据
    @Autowired
    private Environment environment;

    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is running...");
        System.out.println(country);
        System.out.println(name);
        System.out.println(like);
        System.out.println(age);
        System.out.println("------------------------------");
        System.out.println(environment.getProperty("user6[0].age"));
        System.out.println(environment.getProperty("likes[2]"));
        System.out.println("------------------------------");
        System.out.println(myDateSource);
        return "springboot is running";
    }
}
