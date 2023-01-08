package day13_client.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;
        if(condition){
            builder.status(Status.UP);  //设置状态
            builder.withDetail("runTime",System.currentTimeMillis());
            Map infoMap = new HashMap();
            infoMap.put("buildTime","2023");
            builder.withDetails(infoMap);
//            builder.up();  //设置状态  一般用17行那么写
        }else {
            builder.status(Status.DOWN);
            builder.withDetail("上线了吗","你做梦");
//            builder.down();  //设置状态
        }

    }
}
