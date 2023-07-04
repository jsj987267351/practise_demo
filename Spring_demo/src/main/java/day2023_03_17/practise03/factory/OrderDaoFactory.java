package day2023_03_17.practise03.factory;

import day2023_03_17.practise03.dao.OrderDao;
import day2023_03_17.practise03.dao.impl.OrderDaoImpl;
//静态工厂创建对象
public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
//        System.out.println("factory setup....");
        return new OrderDaoImpl();
    }
}
