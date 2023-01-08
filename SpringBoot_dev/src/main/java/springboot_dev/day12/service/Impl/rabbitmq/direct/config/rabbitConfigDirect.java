//package springboot_dev.day12.service.Impl.rabbitmq.direct.config;
//
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class rabbitConfigDirect {
//
////    消息队列名称
//    @Bean
//    public Queue directQueue(){
//        return new Queue("direct_queue");
//    }
//
////    交换机
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange("directExchange");
//    }
//
////    绑定
//    @Bean
//    public Binding bindingDirect(){
//        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
//    }
//}
