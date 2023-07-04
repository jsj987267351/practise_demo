package day2023_03_18.practise14;

import day2023_03_18.practise14.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
