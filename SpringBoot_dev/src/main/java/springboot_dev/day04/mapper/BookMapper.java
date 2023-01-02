package springboot_dev.day04.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot_dev.day04.pojo.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {


}
