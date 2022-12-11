package springboot_basis.day05.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot_basis.day05.pojo.Book;


//mybatis plus
//@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
