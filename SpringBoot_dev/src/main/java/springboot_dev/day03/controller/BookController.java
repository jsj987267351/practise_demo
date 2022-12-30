package springboot_dev.day03.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_dev.day03.pojo.Book;

//@RestController
//@RequestMapping("/books")
public class BookController {

//    @GetMapping
//    public String getById(){
//        System.out.println("running...");
//        return "springboot";
//    }

    @GetMapping
    public Book getById(){
        System.out.println("running...");

        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

        return book;
    }
}
