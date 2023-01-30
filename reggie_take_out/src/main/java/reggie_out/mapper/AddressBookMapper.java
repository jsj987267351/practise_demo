package reggie_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import reggie_out.pojo.AddressBook;

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
