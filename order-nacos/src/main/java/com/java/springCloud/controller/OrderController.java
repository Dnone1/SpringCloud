package com.java.springCloud.controller;

import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplatet;


    @RequestMapping("/add")
    @Trace
    @Tags({
            @Tag(value = "/add" , key = "returnedObj")
    })
    public String addOrder() {
        System.out.println("添加订单");
        String forObject = restTemplatet.getForObject("http://stock-nacos/stock/decrease", String.class);
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        return "nacos:\nhelloword "+forObject;
    }

    @RequestMapping("/head")
   public String getHead(@RequestHeader("X‐Request‐color") String header) {
        System.out.println(header);
        return header;
    }

    /**
     * 关联流控，访问addOrder，触发get
     * @return
     */
    @RequestMapping("/get/{id}")
    @Trace
    @Tags({
            @Tag(value = "/get" , key = "arg[0]")
    })
    public String get(@PathVariable("id") Integer id) {
        return "查询订单"+id;
    }

    /**
     * 线程流控和Qps流控区别
     * 线程流控：线程流控是通过限制并发执行的线程数量来控制流量。当并发请求数达到设定的阈值时，多余的请求将被阻塞或拒绝
     * Qps流控：指的是每秒钟能够处理的请求数量。QPS流控通过设置一个固定的阈值来限制每秒可以处理的请求量。一旦达到限制，多余的请求将被阻塞或拒绝
     * @return
     */
    @RequestMapping("/flow")
    public String flow() throws InterruptedException {
        return "正常访问";
    }


    @RequestMapping("/addOrderTwo")
    //@SentinelResource(value = "addOrderTwo" , blockHandler = "flowBlockHandler")
    public String addOrderTwo() throws InterruptedException {
        Thread.sleep(5000);
        return "订单成功";
    }

    @RequestMapping("/err")
    public String err() {
        int i = 10 / 0 ;
        return "hello";
    }

}
