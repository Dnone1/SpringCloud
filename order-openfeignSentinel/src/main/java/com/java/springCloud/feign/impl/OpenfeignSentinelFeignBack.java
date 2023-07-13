package com.java.springCloud.feign.impl;

import com.java.springCloud.feign.OpenfeignSentinelFeign;
import org.springframework.stereotype.Component;

@Component
public class OpenfeignSentinelFeignBack implements OpenfeignSentinelFeign {
    public String decrease2() {
        return "降级啦";
    }
}
