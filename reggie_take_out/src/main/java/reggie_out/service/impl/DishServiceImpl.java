package reggie_out.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reggie_out.dto.DishDto;
import reggie_out.mapper.DishMapper;
import reggie_out.pojo.Dish;
import reggie_out.pojo.DishFlavor;
import reggie_out.service.DishFlavorService;
import reggie_out.service.DishService;

import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时插入菜品对应的口味数据
     *
     * @param dishDto
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
//        保存菜品的基本信息到菜品表dish
        this.save(dishDto);
//      菜品id
        Long dishId = dishDto.getId();
        List<DishFlavor> flavors = dishDto.getFlavors();

        for (DishFlavor flavor: flavors){
            flavor.setDishId(dishId);
        }
//        保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据id查询菜品信息和口味信息
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {
//        查询菜品信息
        Dish dish = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

//        查询口味信息
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(lambdaQueryWrapper);

        dishDto.setFlavors(flavors);

        return dishDto;
    }

    /**
     * 更新菜品信息与口味信息
     * @param dishDto
     */
    @Override
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
//        更新菜品表 dish
        this.updateById(dishDto);
//        清理当前菜品对应口味数据  ---dish_flavor表的delete操作
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(lambdaQueryWrapper);
//        添加当前提交过来的口味数据 ---dish_flavor表的insert操作
        List<DishFlavor> flavors = dishDto.getFlavors();
        Long id = dishDto.getId();
        for (DishFlavor flavor: flavors){
            flavor.setDishId(id);
        }
        dishFlavorService.saveBatch(flavors);
    }
}
