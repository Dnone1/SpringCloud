package com.java.springCloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    String value ;

    @RequestMapping("/{id}")
    public String get(@PathVariable("id") int id) throws InterruptedException {
        System.out.println("查询商品");
        //睡眠4秒
        //Thread.sleep(4000);
        return "查询商品："+id+" :"+value;
    }
}
