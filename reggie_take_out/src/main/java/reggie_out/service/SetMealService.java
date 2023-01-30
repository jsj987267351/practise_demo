package reggie_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import reggie_out.dto.SetmealDto;
import reggie_out.pojo.Setmeal;

import java.util.List;

public interface SetMealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
