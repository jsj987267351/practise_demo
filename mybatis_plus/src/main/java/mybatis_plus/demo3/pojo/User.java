package mybatis_plus.demo3.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

//lombok
@Data
//对应表
//可使用配置中的全局配置
//@TableName("tbl_user")
public class User {
//    @TableId(type = IdType.AUTO)
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

//    逻辑删除字段，标记当前记录是否被删除
//    可用配置
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

//    实现乐观锁
    @Version
    private Integer version;
}
