package com.java.springCloud.controller;

import com.java.springCloud.feign.OpenfeignSentinelFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OpenfeignSentinelFeign openfeignSentinelFeign ;

    @RequestMapping("/add2")
    public String add() {
        System.out.println("下单成功");
        String s = openfeignSentinelFeign.decrease2();
        return "helloFeignSentinel"+s;
    }
}
