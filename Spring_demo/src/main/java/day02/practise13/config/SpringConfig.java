package day02.practise13.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("day02.practise13")
//@PropertySource加载properties配置文件  多个用{},且不支持只用通配符：列入*.properties
@PropertySource({"jdbc2.properties"})
public class SpringConfig {
}
