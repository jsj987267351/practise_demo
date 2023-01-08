//package springboot_dev.day12.service.Impl.rabbitmq.direct.listener;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
////@Component
//public class MessageListener2 {
//
////    两个监听器监听同一个空间，则会轮流监听
//    @RabbitListener(queues = "direct_queue")
//    public void receive(String id){
//        System.out.println("已完成短信发送业务(rabbitmq direct 2)，id：" + id);
//    }
//}
