package Mapper;


import POJO.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询
     *
     * @return
     */
//     List<Brand> selectByCondition (@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
//     List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void  deleteByIds(@Param("ids") int []ids);

}
