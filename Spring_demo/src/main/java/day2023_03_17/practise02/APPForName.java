package day2023_03_17.practise02;

import day2023_03_17.practise02.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APPForName {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) ctx.getBean("service");
        bookService.save();
    }
}
