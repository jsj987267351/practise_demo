package springboot_basis.day06.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot_basis.day06.pojo.Book;


//druid
//@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
