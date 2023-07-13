package com.java.springCloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.java.springCloud.service.SentinelService;
import org.springframework.stereotype.Service;

@Service
public class SentinelServiceImpl implements SentinelService {

    @SentinelResource(value = "getUser" , blockHandler = "blockHandlerGetUser")
    public String getUser() {
        return "查询用户";
    }

    public String blockHandlerGetUser(BlockException e) {
        return "被--链路流控--了" ;
    }
}
