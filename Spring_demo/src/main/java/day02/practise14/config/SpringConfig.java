package day02.practise14.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan("day02.practise14")
//@Import:导入配置信息  多个用{}
@Import({JdbcConfig.class})
public class SpringConfig {

}
