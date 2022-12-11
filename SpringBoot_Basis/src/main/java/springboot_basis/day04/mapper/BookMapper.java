package springboot_basis.day04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springboot_basis.day04.pojo.Book;


//mybatis
//@Mapper
public interface BookMapper {
    @Select("select * from tb_book where id = #{id}")
    public Book getById(Integer id);
}
