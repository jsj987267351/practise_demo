package reggie_out.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reggie_out.common.R;
import reggie_out.pojo.Category;
import reggie_out.service.CategoryService;

import javax.security.auth.callback.LanguageCallback;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 新增分类
     *
     * @param category
     * @return
     */

    @PostMapping
    public R<String> save(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
//        分页构造器
        Page<Category> PageInfo = new Page<>(page,pageSize);
//        条件构造器，排序
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        添加排序条件，根据sort进行排序
        lambdaQueryWrapper.orderByAsc(Category::getSort);
        categoryService.page(PageInfo, lambdaQueryWrapper);

        return R.success(PageInfo);
    }


    /**
     * 根据id进行删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids){


//        categoryService.removeById(id);
        categoryService.remove(ids);  //自己在Service中写的
        return R.success("删除成功");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("修改信息成功");
    }

    /**
     * 根据条件查询分类数据
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
//        条件构造器
        LambdaQueryWrapper<Category> lambdaQueryWrapper  = new LambdaQueryWrapper<>();
//        添加条件
        lambdaQueryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
//        添加排序条件
        lambdaQueryWrapper.orderByAsc(Category::getSort,Category::getUpdateTime);

        List<Category> list = categoryService.list(lambdaQueryWrapper);
        return R.success(list);
    }
}
