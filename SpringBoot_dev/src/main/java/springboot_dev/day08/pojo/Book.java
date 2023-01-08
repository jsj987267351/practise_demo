package springboot_dev.day08.pojo;


import lombok.Data;
//实现序列化接口
import java.io.Serializable;

@Data
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
