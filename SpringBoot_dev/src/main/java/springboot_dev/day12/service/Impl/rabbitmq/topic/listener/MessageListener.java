//package springboot_dev.day12.service.Impl.rabbitmq.topic.listener;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
////@Component
//public class MessageListener {
//
//    @RabbitListener(queues = "topic_queue")
//    public void receive(String id){
//        System.out.println("已完成短信发送业务(rabbitmq topic 1)，id：" + id);
//    }
//
//    @RabbitListener(queues = "topic_queue2")
//    public void receive2(String id){
//        System.out.println("已完成短信发送业务(rabbitmq topic 2)，id：" + id);
//    }
//}
