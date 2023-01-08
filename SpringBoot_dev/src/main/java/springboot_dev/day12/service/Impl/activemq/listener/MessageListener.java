//package springboot_dev.day12.service.Impl.activemq.listener;
//
//
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
////定义一个监听器，监听MessageServiceActivemqImpl中的消息队列
////@Component
//public class MessageListener {
//
//    @JmsListener(destination = "order.queue.id")   //设置监听的队列名称
//    @SendTo("other.order.queue.id")    //上面接收完消息处理完成后，会将消息处理后的返回值转发到该目的地
//    public String receive(String id){
//        System.out.println("已完成短信发送业务，id：" + id);
//        return "消息处理后的返回值:" + id;
//    }
//}
