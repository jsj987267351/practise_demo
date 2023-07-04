package day2023_03_19.practise22;

import day2023_03_19.practise22.demo.config.SpringConfig;
import day2023_03_19.practise22.demo.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        String name = bookDao.findName(100,"Joker");
        System.out.println(name);
    }
}
