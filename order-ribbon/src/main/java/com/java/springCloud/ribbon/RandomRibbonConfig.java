package com.java.springCloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class RandomRibbonConfig {


    /**
     * 配置类，全局配置
     *
     * 返回值一定为IRule,方法名一点为iRule
     * 返回参数为想要修改的类
     * @return
     */
    @Bean
    public IRule iRule() {
        // 指定使用Nacos提供的负载均衡策略（优先调用同一集群的实例，基于随机)
        return new RandomRule();
    }
}
