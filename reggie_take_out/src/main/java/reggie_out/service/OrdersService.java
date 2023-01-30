package reggie_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import reggie_out.pojo.Orders;

public interface OrdersService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);

}
