package com.Mybatis.DEMO.demo1;

import Mybatis.Mapper.BrandMapper;
import Mybatis.Mapper.UserMapper;
import Mybatis.POJO.Brand;
import Mybatis.POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class demoUser注解 {
    @Test
    public void Userdemo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByid(1);
        System.out.println(user);

        sqlSession.close();
    }
}
