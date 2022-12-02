package springboot_mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_mybatis.mapper.BookDao;
import springboot_mybatis.pojo.Book;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void testById() {
        Book book = bookDao.getById(2);
        System.out.println(book);
    }

}
