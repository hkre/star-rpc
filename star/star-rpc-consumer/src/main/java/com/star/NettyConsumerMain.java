package com.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 **/
@ComponentScan(basePackages = {"com.star.spring.annotation","com.star.controller", "com.star.spring.reference"})
@SpringBootApplication
public class NettyConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(NettyConsumerMain.class, args);
    }
}
