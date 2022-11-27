package day03.practise23.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("day03.practise23")
@EnableAspectJAutoProxy
public class SpringConfig {
}
