package reggie_out.dto;


import lombok.Data;
import reggie_out.pojo.Dish;
import reggie_out.pojo.DishFlavor;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
