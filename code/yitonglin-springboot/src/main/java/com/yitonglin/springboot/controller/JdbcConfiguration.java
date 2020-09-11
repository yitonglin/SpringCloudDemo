package com.yitonglin.springboot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//声明一个类为配置类，相当于一个xml配置文件
@EnableConfigurationProperties(JdbcProperties.class)//开启使用属性读取类
public class JdbcConfiguration {

    @Autowired
    private JdbcProperties jdbcProperties;


    @Bean//将方法的返回值注入到spring容器
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.jdbcProperties.getDriverClassName());
        dataSource.setUrl(this.jdbcProperties.getUrl());
        dataSource.setUsername(this.jdbcProperties.getUsername());
        dataSource.setPassword(this.jdbcProperties.getPassword());
        return dataSource;
    }


}
