package springboot_basis.SSMP.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot_basis.SSMP.pojo.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {


}
