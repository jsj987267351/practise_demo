package day01.practise03.factory;

import day01.practise03.dao.UserDao;
import day01.practise03.dao.impl.UserDaoImpl;
//实例工厂创建对象
public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
