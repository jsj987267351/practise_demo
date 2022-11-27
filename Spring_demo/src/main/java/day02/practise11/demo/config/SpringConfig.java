package day02.practise11.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * Configuration 表明当前类为注解类
 * ComponentScan  包扫描 多个用数组
 */
@Configuration
@ComponentScan({"day02.practise11.demo.dao","day02.practise11.demo.service"})
public class SpringConfig {
}
