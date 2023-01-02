package springboot_dev.day04;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_dev.day04.mapper.BookMapper;

@SpringBootTest
public class Test04 {
    @Autowired
    private BookMapper bookMapper;

   @Test
    void test(){
       bookMapper.selectById(1);
   }
}
