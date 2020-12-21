package com.example.mall.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mall.storage.mapper")
public class MallStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallStorageServiceApplication.class, args);
    }

}
