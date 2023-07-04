package day2023_03_19.practise21.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("day2023_03_19.practise21")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}
