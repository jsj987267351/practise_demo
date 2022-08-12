package service;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;
import pojo.PageBean;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    void add(Brand brand);

//    void update(Brand brand);


    void deleteByIds(int []ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize   每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);


    void modify(Brand brand);

    void deleteById(int id);

}
