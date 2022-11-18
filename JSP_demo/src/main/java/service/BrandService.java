package service;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class BrandService {

    SqlSessionFactory Factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {

        SqlSession sqlSession = Factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;

    }

    public void Add(Brand brand) {

        SqlSession sqlSession = Factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();

        sqlSession.close();

    }

    public Brand selectById(int id) {

        SqlSession sqlSession = Factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();

        return brand;

    }
    public void update(Brand brand) {

        SqlSession sqlSession = Factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);

        sqlSession.commit();
        sqlSession.close();
    }


    public void deleteById(int id) {

        SqlSession sqlSession = Factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }

}
