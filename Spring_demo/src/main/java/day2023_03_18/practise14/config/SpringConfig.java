package day2023_03_18.practise14.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("day2023_03_18.practise14")
//@Import:导入配置信息  多个用{}
@Import({JdbcConfig.class})
public class SpringConfig {

}
