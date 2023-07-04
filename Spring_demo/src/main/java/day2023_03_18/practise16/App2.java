package day2023_03_18.practise16;

import day2023_03_18.practise16.demo.config.SpringConfig;
import day2023_03_18.practise16.demo.pojo.Account;
import day2023_03_18.practise16.demo.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService accountService = ctx.getBean(AccountService.class);

        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}
