package Mybatis.Mapper;

import Mybatis.POJO.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface BrandMapper {

//    查询所有
    ArrayList<Brand> selectAll();

    Brand selectByid(int id);

    /*
    * 条件查询
    *        1.散装参数：如果方法中有多个参数，常用@Param（“SQL参数占位符名称”）
    *        2.对象参数：对象的属性名称要和参数占位符一致
    *        3.map集合参数
    * */

//    ArrayList<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    ArrayList<Brand> selectByCondition(Brand brand);
//
    ArrayList<Brand> selectByCondition(Map map);

    /*
    * 单条件动态查询
    *
    * */
    ArrayList<Brand> selectByConditionsingle(Brand brand);

    /*
    * 添加
    * */

    void add(Brand brand);
    /*
     * 修改
     * */

    int update(Brand brand);
    /*
     * 根据id删除单个
     * */

    void deleteByid(int id);
    /*
     * 批量删除
     * */

    void deleteByids(@Param("ids") int []ids);

}
