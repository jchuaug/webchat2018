package com.xmu.middleware.webchat2018;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xmu.middleware.webchat2018")
public class Webchat2018Application {

    public static void main(String[] args) {
        SpringApplication.run(Webchat2018Application.class, args);
    }
}
