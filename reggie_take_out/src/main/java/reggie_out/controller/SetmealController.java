package reggie_out.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reggie_out.common.R;
import reggie_out.dto.SetmealDto;
import reggie_out.pojo.Category;
import reggie_out.pojo.Setmeal;
import reggie_out.service.CategoryService;
import reggie_out.service.SetMealService;
import reggie_out.service.SetmealDishService;

import java.util.ArrayList;
import java.util.List;


/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    private SetMealService setMealService;

    @Autowired
    private SetmealDishService setmealDishService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("套餐信息:{}",setmealDto);
        setMealService.saveWithDish(setmealDto);
        return null;
    }


    /**
     * 套餐分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping ("/page")
    public R<Page> page(int page,int pageSize, String name){
//        构造分页构造器
        Page<Setmeal> pageInfo = new Page(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name!=null,Setmeal::getName,name);
        lambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setMealService.page(pageInfo, lambdaQueryWrapper);
//        对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();

//        流的方法遍历，与下面一样
//        List<SetmealDto> list = records.stream().map((item) -> {
//            SetmealDto setmealDto = new SetmealDto();
//            //对象拷贝
//            BeanUtils.copyProperties(item,setmealDto);
//            //分类id
//            Long categoryId = item.getCategoryId();
//            //根据分类id查询分类对象
//            Category category = categoryService.getById(categoryId);
//            if(category != null){
//                //分类名称
//                String categoryName = category.getName();
//                setmealDto.setCategoryName(categoryName);
//            }
//            return setmealDto;
//        }).collect(Collectors.toList());

        List<SetmealDto> list = new ArrayList<>();
        for (Setmeal setmeal: records){
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(setmeal,setmealDto);
            Long id = setmeal.getCategoryId();
            Category category = categoryService.getById(id);
            if(category!=null){
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
                list.add(setmealDto);
            }
        }

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }

    /**
     * 删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids){
        log.info("ids{}",ids);
        setMealService.removeWithDish(ids);
        return R.success("套餐数据删除成功");
    }

    /**
     * 根据条件查询套餐
     * @param setmeal
     * @return
     */
    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(setmeal.getCategoryId()!=null,Setmeal::getCategoryId,setmeal.getCategoryId());
        lambdaQueryWrapper.eq(setmeal.getStatus()!=null,Setmeal::getStatus,setmeal.getStatus());
        lambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setMealService.list(lambdaQueryWrapper);
        return R.success(list);
    }

}
