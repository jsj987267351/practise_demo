package service;
import pojo.Brand;
import pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加
     */

    void add(Brand brand);

    /**
     * 修改
     */
    void update(Brand brand);


    /**
     * 删除
     */
    void deleteById(int id);

    /**
     * 批量删除
     */
    void deleteByIds(int [] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize 查询条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);

}
