package com.java.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos-config")
@RefreshScope
public class NacosConfigController {

    @Value("${user.name}")
    private String name ;

    @RequestMapping("/name")
    public String  getName() {
        return name ;
    }
}
