package com.java.springCloud.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service" , path = "/product")
public interface ProductFeign {

    /**
     * @PathVariable("id") int id
     * PathVariable必须指定名字，否者就会报错
     * @param id
     * @return
     */
    @RequestMapping("/{id}")                         //@RequestLine feign的原生注解
    public String get(@PathVariable("id") int id) ;     //@Param() feign的原生注解
}

/**
 * @RestController
 * @RequestMapping("/product")
 * public class ProductController {
 *
 *     @Value("${server.port}")
 *     String value ;
 *
 *     @RequestMapping("/{id}")
 *     public String get(@PathVariable("id") int id) {
 *         System.out.println("查询商品");
 *         return "查询商品："+id+" :"+value;
 *     }
 * }
 */
