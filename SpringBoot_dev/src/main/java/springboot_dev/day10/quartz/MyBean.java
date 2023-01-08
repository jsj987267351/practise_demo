package springboot_dev.day10.quartz;


import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class MyBean {

    @Scheduled(cron = "0/1 * * * * *")
    public void print(){
//        名字为yml中配置 ，调试使用
        System.out.println(Thread.currentThread().getName()+ ": spring task run...");
    }
}
