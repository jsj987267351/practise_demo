package day2023_03_18.practise13;

import day2023_03_18.practise13.config.SpringConfig;
import day2023_03_18.practise13.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}
