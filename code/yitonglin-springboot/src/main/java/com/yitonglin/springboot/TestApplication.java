package com.yitonglin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//此为引导类为springboot应用的入口
//@EnableAutoConfiguration//启用SpringBoot的自动配置
//@ComponentScan//此为扫描注解 类似于<context:component-scan base-package="">默认扫描此文件下所在包以及子孙包
@SpringBootApplication//此注解已包含了上面两个注解
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
