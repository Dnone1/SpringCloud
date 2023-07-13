package com.java.springCloud.feign;


import com.java.springCloud.config.OrderOpenfeignConfig;
import com.java.springCloud.feign.impl.OpenfeignSentinelFeignBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "stock-nacos" ,path = "/stock" ,fallback = OpenfeignSentinelFeignBack.class)
public interface OpenfeignSentinelFeign {

    @RequestMapping("/decrease2")
    public String decrease2() ;

}
