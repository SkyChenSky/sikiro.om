package com.sikiro.om.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan(basePackages = {"com.sikiro.om"})
@MapperScan("com.sikiro.om")
public class SikiroOmApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SikiroOmApiApplication.class, args);
    }
}
