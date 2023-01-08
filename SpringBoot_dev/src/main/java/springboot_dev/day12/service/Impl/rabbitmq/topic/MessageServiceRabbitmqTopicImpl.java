//package springboot_dev.day12.service.Impl.rabbitmq.topic;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import springboot_dev.day12.service.MessageService;
//
//
////@Service
//public class MessageServiceRabbitmqTopicImpl implements MessageService {
//
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("待发送短信的订单已纳入处理队列(rabbitmq topic)，id：" + id);
//        amqpTemplate.convertAndSend("topicExchange","topic.order.id",id);  //config配置中交换机，邦定机，消息
//    }
//
//    @Override
//    public String doMessage() {
//        return null;
//    }
//}
