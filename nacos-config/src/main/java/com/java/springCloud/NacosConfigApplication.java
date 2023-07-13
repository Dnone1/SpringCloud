package com.java.springCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);

        while (true){
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.out.println("common name :"+userName+"; age: "+userAge+"; config: "+config);
            TimeUnit.SECONDS.sleep(3);
        }
    }

}
