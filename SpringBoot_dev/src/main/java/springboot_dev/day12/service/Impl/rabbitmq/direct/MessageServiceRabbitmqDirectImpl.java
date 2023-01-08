//package springboot_dev.day12.service.Impl.rabbitmq.direct;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import springboot_dev.day12.service.MessageService;
//
//
////@Service
//public class MessageServiceRabbitmqDirectImpl implements MessageService {
//
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("待发送短信的订单已纳入处理队列(rabbitmq direct)，id：" + id);
//        amqpTemplate.convertAndSend("directExchange","direct",id);  //config配置中交换机，邦定机，消息
//    }
//
//    @Override
//    public String doMessage() {
//        return null;
//    }
//}
