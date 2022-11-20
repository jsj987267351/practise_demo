package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import utils.SqlSessionFactoryUtils;



public class UserService {
    SqlSessionFactory Factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User Login(String username , String password){

        SqlSession sqlSession = Factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);

        sqlSession.close();

        return user;
    }


    public boolean register(User user) {

        SqlSession sqlSession = Factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            //用户名不存在
            mapper.add(user);
            sqlSession.commit();
            return true;
        }

        return u==null;
    }
}
