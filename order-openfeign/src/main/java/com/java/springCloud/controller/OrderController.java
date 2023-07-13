package com.java.springCloud.controller;

import com.java.springCloud.feign.OrderFeign;
import com.java.springCloud.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFeign orderFeign ;

    @Autowired
    private ProductFeign productFeign ;

    @RequestMapping("/add")
    public String addOrder() {
        System.out.println("添加订单");
        String msg = orderFeign.decrease();
        String s = productFeign.get(12);
        return "hello openfeign:\t "+msg+s;
    }
}
