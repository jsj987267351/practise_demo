package springboot_dev;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springboot_dev.day02.config.ServerConfig;

@SpringBootApplication
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
