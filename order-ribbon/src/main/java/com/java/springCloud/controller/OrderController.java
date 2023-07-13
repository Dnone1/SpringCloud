package com.java.springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplatet;


    @RequestMapping("/add")
    public String addOrder() {
        System.out.println("添加订单");
        String forObject = restTemplatet.getForObject("http://stock-nacos/stock/decrease", String.class);
        return "nacos:\nhelloword "+forObject;
    }
}
