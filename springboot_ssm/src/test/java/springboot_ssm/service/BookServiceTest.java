package springboot_ssm.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_ssm.pojo.Book;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGrtById(){
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    @Test
    public void testAll(){

        List<Book> books = bookService.getAll();
        System.out.println(books);
    }
}
