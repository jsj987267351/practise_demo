package springboot_dev.day03.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private Integer id;
    private Integer id2;
    private Integer id3;
    private String name;
    private String uuid;
    private long publishTime;
}
