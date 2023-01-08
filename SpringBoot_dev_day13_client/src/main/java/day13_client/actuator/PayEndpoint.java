package day13_client.actuator;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
//自定义端点
@Endpoint(id = "pay",enableByDefault = true)
public class PayEndpoint {


    @ReadOperation
    public Object getPay(){
        Map payMap = new HashMap();
        payMap.put("青铜","100");
        payMap.put("白银","1000");
        payMap.put("黄金","10000");
        return payMap;

    }
}
