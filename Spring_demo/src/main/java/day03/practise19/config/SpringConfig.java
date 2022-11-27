package day03.practise19.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("day03.practise19")
@EnableAspectJAutoProxy
public class SpringConfig {
}
