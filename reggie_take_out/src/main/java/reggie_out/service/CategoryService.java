package reggie_out.service;


import com.baomidou.mybatisplus.extension.service.IService;
import reggie_out.pojo.Category;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
