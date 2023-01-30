package reggie_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import reggie_out.pojo.Orders;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
