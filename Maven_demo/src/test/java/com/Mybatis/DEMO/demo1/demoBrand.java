package com.Mybatis.DEMO.demo1;

import Mybatis.Mapper.BrandMapper;
import Mybatis.POJO.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demoBrand {

    @Test
    public void testSelectALL() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        ArrayList<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        sqlSession.close();
    }
    @Test
    public void testSelecByid() throws IOException {
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectByid(id);
        System.out.println(brand);

        sqlSession.close();
    }


    @Test
    public void testSelecByCondition() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        ArrayList<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
//        ArrayList<Brand> brands = mapper.selectByCondition(brand);
        ArrayList<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);

        sqlSession.close();

    }


    @Test
    public void testSelecByConditionSingle() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        ArrayList<Brand> brands = mapper.selectByConditionsingle(brand);
        System.out.println(brands);

        sqlSession.close();

    }


    @Test
    public void testAdd() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);

//       提交事务
//        sqlSession.commit();

        sqlSession.close();

    }


    @Test
    public void testAdd2() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);

        System.out.println(brand.getId());


        sqlSession.close();

    }



    @Test
    public void testUpdate() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id =5;


        Brand brand = new Brand();
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setId(id);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.update(brand);
        System.out.println(i);


        sqlSession.close();

    }
//  动态
    @Test
    public void testUpdate2() throws IOException {

        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id =6;

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        brand.setId(id);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.update(brand);
        System.out.println(i);


        sqlSession.close();

    }


    @Test
    public void testdeleteByid() throws IOException {


        int id =6;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByid(id);

        sqlSession.close();

    }


    @Test
    public void testdeleteByids() throws IOException {


        int ids[] = {5 ,7,8};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByids(ids);

        sqlSession.close();

    }








}



