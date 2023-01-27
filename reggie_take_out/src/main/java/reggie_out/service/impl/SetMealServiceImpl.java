package reggie_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import reggie_out.mapper.SetMealMapper;
import reggie_out.pojo.Setmeal;
import reggie_out.service.SetMealService;

@Service
public class SetMealServiceImpl extends ServiceImpl<SetMealMapper, Setmeal> implements SetMealService {
}
