package com.java.springCloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.java.springCloud.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/orderSentinel")
public class SentinelController {

    @Autowired
    private SentinelService sentinelService ;

    @RequestMapping("/addOrder")
    //@SentinelResource(value = "addOrder" , blockHandler = "flowBlockHandler")
    public String addOrder() {
        return "订单成功";
    }

    /**
     * 关联流控，访问addOrder，触发get
     * @return
     */
    @RequestMapping("/get")
    public String get() {
        return "查询订单";
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

    public String flowBlockHandler(BlockException blockException) {
        return "您访问的太频繁了~请稍等一下~🥰";
    }

    @RequestMapping("/addOrderTwo")
    //@SentinelResource(value = "addOrderTwo" , blockHandler = "flowBlockHandler")
    public String addOrderTwo() throws InterruptedException {
        Thread.sleep(5000);
        return "订单成功";
    }

    @RequestMapping("/text1")
    public String text1() {
        return sentinelService.getUser();
    }

    @RequestMapping("/text2")
    public String text2() {
        return sentinelService.getUser();
    }

    @RequestMapping("/err")
    public String err() {
        int i = 10 / 0 ;
        return "hello";
    }

    /**
     * 关联流控和链路流控的区别
     *
     *
     * 关联（Association） 是基于某个资源的触￥￥况来进行流控的规则。当一个资源被访问并达到一定阈值时，可以触发与该资源相关的其他资源的流控操作。关联可以帮助我们限制多个相关资源的总体访问，保护这些资源免受过度使用或滥用。
     * 举个例子来说，假设我们有一个网站后台管理系统，其中包括了用户管理、订单管理和商品管理三个资源。我们可以设置一个关联规则，当用户管理模块的接口请求量超过某个阈值时，触发对订单管理和商品管理模块的流控操作，限制它们的访问速率或请求量。
     *
     * 链路（Flow） 是基于某个业务流程的执行情况来进行流控的规则。当一个业务流程被触发时，可以针对该流程的每个环节设置不同的流控策略。这样能够在不同环节对流程进行细粒度的控制，避免因某个环节的异常而对整个流程造成影响。
     * 例如，考虑一个电商平台的下单流程，整个流程包括选择商品、填写收货地址、支付等环节。我们可以为每个环节设置不同的流控规则，例如选择商品环节限制并发访问量，填写收货地址环节限制每分钟请求量，支付环节限制每秒钟的请求数量。
     *
     * Warm Up:
     * 冷加载因子: codeFactor 默认是3，即请求 QPS 从 threshold / 3 开始，经预热时长逐渐升至设定的 QPS 阈值。
     */


    /**
     * 热点流控，： 资源名必须是@SentinelResource(value="资源名")中 配置的资源名，热点规则依赖于注解
     * @param id
     * @return
     */
    @RequestMapping("/getById/{id}")
    @SentinelResource(value = "/getById" , blockHandler = "hotspotBlockHandler")
    public String getById(@PathVariable("id") int id) {
        System.out.println("正常访问");
        return "正常访问"+id ;
    }

    public String hotspotBlockHandler(@PathVariable("id") int id , BlockException e) {
        return "热点异常处理" ;
    }




}
