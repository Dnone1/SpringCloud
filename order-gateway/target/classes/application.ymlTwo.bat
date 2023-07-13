server:
  port: 8011

spring:
  application:
    name: gateway
  cloud:
    #gateway的配置 ，这样配置就必须用服务名进行访问，断言也必须用服务名进行断言
    gateway:
      discovery:
        locator:
          enabled: true  #是否自动识别nacos服务
    nacos:
      server-addr: 127.0.0.1:8848
      username: nacos
      password: nacos

