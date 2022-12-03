package mybatis_plus.demo1.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatis_plus.demo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
}
