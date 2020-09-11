package com.yitonglin.eureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//声明当前springboot程序为Eureka服务中心
public class YitonglinEurekaApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(YitonglinEurekaApplication2.class, args);
    }

}
