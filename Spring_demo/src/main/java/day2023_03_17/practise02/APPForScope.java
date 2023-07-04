package day2023_03_17.practise02;


import day2023_03_17.practise02.mapper.BookDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APPForScope {
    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");


        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);

    }
}
