package springboot_dev.day10.config;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot_dev.day10.quartz.MyQuartz;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
//工作明细，绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printTrigger() {

//        触发器，绑定具体的工作明细   秒，分，时，日，月，周  ?为自动匹配前面    cron表达式可以网上搜
        ScheduleBuilder ScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(ScheduleBuilder).build();
    }
}
