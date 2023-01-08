package springboot_dev;

import com.alibaba.druid.pool.DruidDataSource;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springboot_dev.day02.config.ServerConfig;

@SpringBootApplication
//day07 开启缓存功能
//@EnableCaching
// day08 开启jetcache缓存的主开关
//@EnableCreateCacheAnnotation

//开启方法缓存与@EnableCreateCacheAnnotation一起使用  basePackages要覆盖到使用注解的方法
//@EnableMethodCache(basePackages = "springboot_dev.day08")
//开启定时任务功能 day10
//@EnableScheduling
//day13 springboot admin 监控
@EnableAdminServer
public class SpringBootDevApplication {

//    day02
//    @Bean
//    @ConfigurationProperties(prefix = "datasource")
//    public DruidDataSource dataSource(){
//        DruidDataSource ds = new DruidDataSource();
////        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        return ds;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevApplication.class, args);
//        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootDevApplication.class, args);
//        ServerConfig bean = ctx.getBean(ServerConfig.class);
//        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
//        System.out.println(ds.getDriverClassName());
//        System.out.println(bean);
    }

}
