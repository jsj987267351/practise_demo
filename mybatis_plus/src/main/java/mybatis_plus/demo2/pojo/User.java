package mybatis_plus.demo2.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//lombok
@Data
//对应表
@TableName("tbl_user")
public class User {
    private Long id;
    private String name;
//    对应数据库中的名称         表明该字段不参与查询
    @TableField(value = "pwd",select = false)
    private String password;
    private Integer age;
    private String tel;
//表明该字段在数据库中不存在，为自己使用
    @TableField(exist = false)
    private Integer online;
}
