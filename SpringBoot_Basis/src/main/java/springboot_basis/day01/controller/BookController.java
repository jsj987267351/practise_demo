package springboot_basis.day01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest 模式
//@RestController
//@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is running...");
        return "springboot is running";
    }
}
