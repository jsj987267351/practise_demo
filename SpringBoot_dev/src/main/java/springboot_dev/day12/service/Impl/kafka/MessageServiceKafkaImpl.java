//package springboot_dev.day12.service.Impl.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import springboot_dev.day12.service.MessageService;
//
//
////@Service
//public class MessageServiceKafkaImpl implements MessageService {
//
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("待发送短信的订单已纳入处理队列(kafka)，id：" + id);
//        kafkaTemplate.send("itheima2023",id);
//    }
//
//    @Override
//    public String doMessage() {
//        return null;
//    }
//}
