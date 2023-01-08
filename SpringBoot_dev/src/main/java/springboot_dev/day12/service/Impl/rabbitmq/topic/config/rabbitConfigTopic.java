//package springboot_dev.day12.service.Impl.rabbitmq.topic.config;
//
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class rabbitConfigTopic {
//
////    消息队列名称
//    @Bean
//    public Queue topicQueue(){
//        return new Queue("topic_queue");
//    }
//
//    @Bean
//    public Queue topicQueue2(){
//        return new Queue("topic_queue2");
//    }
//
////    交换机
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange("topicExchange");
//    }
//
////    绑定
//    @Bean
//    public Binding bindingtopic(){
//        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");  //可以使用模糊匹配 *表示一个单词，#表示任意  如果多个队列都能匹配上，则都会放入
//    }
//
//    @Bean
//    public Binding bindingtopic2(){
//        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic2");
//    }
//}
