package day2023_03_17.practise01;


import day2023_03_17.practise01.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP2 {
    public static void main(String[] args) {

        //1.  2. 在applicationContext.xml
        //3.获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //4.获取bean
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

    }
}
