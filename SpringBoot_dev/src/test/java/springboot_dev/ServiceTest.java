package springboot_dev;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import springboot_dev.day03.pojo.Book;
import springboot_dev.day03.service.BookService;



@SpringBootTest
//开启事务
@Transactional
//自动回滚
@Rollback(true)
public class ServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void  testSave(){
        Book book = new Book();
        book.setId(1);
        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("springboot2");
        bookService.save(book);
    }
}
