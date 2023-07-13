package com.java.springCloud.feign;

import com.java.springCloud.config.OrderOpenfeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name: 指定request接口所对应的服务名
 * path: 指定调用request接口所在Controller类上的接口路径
 * configuration: 局部配置feign的日志，当指定了局部配置的时候，配置类就不能添加@Configuration注解
 */

@FeignClient(name = "stock-nacos" , path = "/stock"  ,configuration = OrderOpenfeignConfig.class)
public interface OrderFeign {

    @RequestMapping("/decrease")
      public String decrease() ;


}

/**
 * @RestController
 * @RequestMapping("/stock")
 * public class StockController {
 *
 *     @Value("${server.port}")
 *     String port ;
 *
 *     @RequestMapping("/decrease")
 *     public String decrease() {
 *         System.out.println("库存减少");
 *         return "库存减少"+port;
 *     }
 * }
 */


