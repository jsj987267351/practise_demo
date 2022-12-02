package springboot_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_demo.demo7.BookService;

import javax.xml.ws.soap.Addressing;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    BookService bookService;

    @Test
    public void save(){
        bookService.save();
    }

}
