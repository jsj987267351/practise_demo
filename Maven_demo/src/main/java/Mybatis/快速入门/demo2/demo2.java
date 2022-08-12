package Mybatis.快速入门.demo2;

import Mybatis.Mapper.UserMapper;
import Mybatis.POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class demo2 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sql = sqlSessionFactory.openSession();

        UserMapper userMapper = sql.getMapper(UserMapper.class);
        ArrayList<User> users = userMapper.selectAll();
        System.out.println(users);

        sql.close();

    }
}
