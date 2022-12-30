package springboot_dev.day02.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
//@Data
//@ConfigurationProperties(prefix = "servers")
//2. 属性校验 开启对当前bean得属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    @Max(value = 8888,message = "最大值不能超过8888")
    private int port;
    private long timeout;
//    时间单位
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
//    存储空间单位
//    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
