package reggie_out.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import reggie_out.mapper.DishMapper;
import reggie_out.pojo.Dish;
import reggie_out.service.DishService;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>implements DishService {
}
