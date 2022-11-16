package Mapper;

import POJO.User;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


public interface UserMapper {

    ArrayList<User> selectAll();

    @Select("select * from tb_user where id = #{id}")
    User selectbyid(int id);
}
