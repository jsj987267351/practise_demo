package springboot_dev.day03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
public class MsgConfig {

    @Bean
    public String msg(){
        return "bean msg";
    }

}
