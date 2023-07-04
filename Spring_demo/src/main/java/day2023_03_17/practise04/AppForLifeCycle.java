package day2023_03_17.practise04;

import day2023_03_17.practise04.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        //注册关闭钩子函数，在虚拟机退出之前回调此函数，关闭容器  位置皆可
        ctx.registerShutdownHook();
        //关闭容器  偏暴力一些 位置只能最后
//        ctx.close();
    }
}
