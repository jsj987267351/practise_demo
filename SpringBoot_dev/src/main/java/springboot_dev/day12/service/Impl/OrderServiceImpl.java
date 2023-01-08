package springboot_dev.day12.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_dev.day12.service.MessageService;
import springboot_dev.day12.service.OrderService;

//@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;
    @Override
    public void order(String id) {

//        一系列操作，包含各种服务调用，处理各种业务，（模拟）
        System.out.println("订单开始");
        messageService.sendMessage(id);
//        短信消息处理
        System.out.println("订单结束");
        System.out.println();
    }
}
