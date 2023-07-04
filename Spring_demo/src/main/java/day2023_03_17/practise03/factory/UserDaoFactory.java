package day2023_03_17.practise03.factory;

import day2023_03_17.practise03.dao.UserDao;
import day2023_03_17.practise03.dao.impl.UserDaoImpl;
//实例工厂创建对象
public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
