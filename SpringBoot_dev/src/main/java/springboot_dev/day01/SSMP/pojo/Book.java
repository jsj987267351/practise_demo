package springboot_dev.day01.SSMP.pojo;


import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
