package com.yitonglin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker//开启熔断注解
@SpringCloudApplication  //此注解包含上面的三个注解
@EnableFeignClients //开启feign客户端
public class YitonglinServiceConsumerApplication {

    //使用feifn 因为已经自动集成了Ribbon负载均衡的RestTemplate。所以，此处不需要再注册RestTemplate。  所以此处先注释
//    @Bean
//    @LoadBalanced  //此注解开启Ribbon负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }


    public static void main(String[] args) {
        SpringApplication.run(YitonglinServiceConsumerApplication.class, args);
    }

}
