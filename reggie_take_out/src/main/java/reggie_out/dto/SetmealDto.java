package reggie_out.dto;


import lombok.Data;
import reggie_out.pojo.Setmeal;
import reggie_out.pojo.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
