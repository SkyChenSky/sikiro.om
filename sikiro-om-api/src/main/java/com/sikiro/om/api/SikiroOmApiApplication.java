package com.sikiro.om.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan(basePackages = {"com.sikiro.om"})
public class SikiroOmApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SikiroOmApiApplication.class, args);
    }
}
