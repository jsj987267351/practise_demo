package springboot_dev.day05;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import springboot_dev.day05.pojo.Book;

import java.util.List;

@SpringBootTest
public class Mongodb {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    void testSave(){

        Book book = new Book();
        book.setId(2);
        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("springboot2");
        mongoTemplate.save(book);
    }

    @Test
    void testGet(){
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);

    }
}
