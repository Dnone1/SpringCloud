package com.java.springCloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
/**
 * 配置类的方式修改负载均衡
 * 在执行类种，添加该注解指定配置类即可
 */
/*@RibbonClients(
        @RibbonClient(name = "stock-nacos" , configuration = RandomRibbonConfig.class)
)*/
public class OrderApplication {



    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class , args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate template(RestTemplateBuilder builder) {
        RestTemplate build = builder.build();
        return build;
    }

}
