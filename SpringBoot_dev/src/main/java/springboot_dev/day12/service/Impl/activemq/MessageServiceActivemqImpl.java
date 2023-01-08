//package springboot_dev.day12.service.Impl.activemq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Service;
//import springboot_dev.day12.service.MessageService;
//
//
//
////@Service
//public class MessageServiceActivemqImpl implements MessageService {
//
//
////    activemq
//    @Autowired
//    private JmsMessagingTemplate messagingTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("待发送短信的订单已纳入处理队列，id：" + id);
//        messagingTemplate.convertAndSend("order.queue.id",id);   //设定存放地点，与yml固定存放位置不同，更灵活
//    }
//
//    @Override
//    public String doMessage() {
//        String id = messagingTemplate.receiveAndConvert("order.queue.id",String.class);
//        System.out.println("已完成短信发送业务，id：" + id);
//        return id;
//
//    }
//}
