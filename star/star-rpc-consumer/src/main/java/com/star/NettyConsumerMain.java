package com.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 **/
@ComponentScan(basePackages = {"com.star.*"})
@SpringBootApplication
public class NettyConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(NettyConsumerMain.class, args);
    }
}
