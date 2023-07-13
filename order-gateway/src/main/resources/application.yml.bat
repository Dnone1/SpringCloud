server:
  port: 8011

spring:
  application:
    name: gateway
  cloud:
    #gateway的配置
    gateway:
      #路由规则
      routes: #这是一个集合，我们可以配置多个，他是根据id转发到uri
        - id: order_route  #路由的唯一标识 ， 我们路由到order
          uri: http://localhost:8081 #需要转发的地址
          #断言规则，用于路由规则的匹配
          predicates:
            - Path=/order-serv/**
              # http://localhost:8011/order-serv/order/add  路由到
              # http://localhost:8082/order-serv/order/add
          #过滤器
          filters:
            - StripPrefix=1  #转发之前去掉第一层路径
            # http://localhost:8082/order/add

