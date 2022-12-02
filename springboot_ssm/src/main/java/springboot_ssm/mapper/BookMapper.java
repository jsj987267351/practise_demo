package springboot_ssm.mapper;//package day02.practise11.mapper;


import org.apache.ibatis.annotations.*;
import springboot_ssm.pojo.Book;

import java.util.List;

//TODO 添加@Mapper
@Mapper
public interface BookMapper {


    @Insert("insert into tbl_book (type,name,description)values (#{type},#{name},#{description})")
    public int add(Book book);

    @Update("update tbl_book set type = #{type},name = #{name},description = #{description} where id = #{id}")
    public int update(Book book);

    @Delete("delete from tbl_book where  id = #{id}")
    public int delete(Integer id);

    @Select("select * from tbl_book where  id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book ")
    public List<Book> getAll();

}
