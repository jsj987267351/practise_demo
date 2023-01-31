package reggie_out.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reggie_out.common.R;
import reggie_out.pojo.Orders;
import reggie_out.service.OrderDetailService;
import reggie_out.service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        ordersService.submit(orders);
        return R.success("下单成功");
    }

//    /**
//     * 查询
//     * @param page
//     * @param pageSize
//     * @param order
//     * @return
//     */
//    @GetMapping("/page")
//    public R<Page> page(int page, int pageSize,Orders order){
//        Page<Orders> pageInfo = new Page<>(page,pageSize);
//        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(order.getNumber()!=null,Orders::getNumber,order.getNumber());
//        lambdaQueryWrapper.gt(Orders::getOrderTime,order.getOrderTime());
//        lambdaQueryWrapper.lt(Orders::getCheckoutTime,order.getCheckoutTime());
//        Page<Orders> ordersPage = ordersService.page(pageInfo, lambdaQueryWrapper);
//        return R.success(ordersPage);
//    }

}
