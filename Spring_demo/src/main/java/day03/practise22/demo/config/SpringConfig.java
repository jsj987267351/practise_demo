package day03.practise22.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("day03.practise22")
@EnableAspectJAutoProxy
public class SpringConfig {
}
