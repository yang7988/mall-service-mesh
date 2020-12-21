package com.example.mall.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example"})
@EnableAspectJAutoProxy( exposeProxy = true )
@MapperScan(basePackages = "com.example.mall.account.mapper")
public class MallAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAccountServiceApplication.class, args);
    }


}
