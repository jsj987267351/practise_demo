package mybatis_plus.demo4.aaa.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张朝证
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String brand_name;

    private String company_name;

    private Integer ordered;

    private String description;

    private Integer status;


}
