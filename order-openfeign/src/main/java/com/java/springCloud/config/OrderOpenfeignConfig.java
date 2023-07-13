package com.java.springCloud.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 注意： 此处配置@Configuration注解就会全局生效
 * 如果想要对某个指定的接口使用，就不能加@Configuration
 *
 * 全局配置只有一种，
 *
 * 局部配置有两种
 *  1： 在yml种配置
 *  2： 在需要配置的接口种配置
 */
//@Configuration
public class OrderOpenfeignConfig {


    /**
     * 日志级别
     * NONE【性能最佳，适用于生产】：不记录任何日志（默认值）。
     * BASIC【适用于生产环境追踪问题】：仅记录请求方法、URL、响应状态代码以及执行时间。
     * HEADERS：记录BASIC级别的基础上，记录请求和响应的header。
     * FULL【比较适用于开发及测试环境定位问题】：记录请求和响应的header、body和元数据。
     *
     * @return
     */
    @Bean
    public Logger.Level feignConfig() {
        return Logger.Level.FULL;
    }

    /**
     * 修改契约配置，支持Feign原生的注解
     * 注意：修改契约配置后，OrderFeignService 不再支持springmvc的注解，需要使用Feign原
     * 生的注解
     * @return
     */
//    @Bean
//    public Contract feignContract() {
//         return new Contract.Default();
//    }


    /**
     * 通过 Options 可以配置连接超时时间和读取超时时间，Options 的第一个参数是连接的超时
     * 时间（ms），默认值是 2s；第二个是请求处理的超时时间（ms），默认值是 5s。
     * 全局配置
     * @return
     */
/*    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }*/


    /**
     * 自定义拦截器
     * @return
     */
/*  @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor(){
         return new FeignAuthRequestInterceptor();

     }
 }*/

}




