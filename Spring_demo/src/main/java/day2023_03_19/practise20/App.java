package day2023_03_19.practise20;

import day2023_03_19.practise20.config.SpringConfig;
import day2023_03_19.practise20.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
//        bookDao.update();
        int num = bookDao.select();
        System.out.println(num);
    }
}
