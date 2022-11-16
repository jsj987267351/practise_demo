package demo;

import Mapper.UserMapper;
import POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatisdemo {
    public static void main(String[] args) throws IOException {

//        1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取SqlSession对象

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3.执行SQL
//        List<Object> Users = sqlSession.selectList("test.selectAll");
//        System.out.println(Users);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

//        4.释放资源
        sqlSession.close();

    }
}
