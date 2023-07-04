package day2023_03_17.practise03.factory;

import day2023_03_17.practise03.dao.UserDao;
import day2023_03_17.practise03.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;
//FactoryBean创建对象
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;  //单例
//        return  false; //非单例
    }
}
