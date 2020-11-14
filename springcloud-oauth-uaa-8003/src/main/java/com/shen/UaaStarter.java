package com.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class UaaStarter {
    public static void main(String[] args) {
        SpringApplication.run(UaaStarter.class, args);
    }
}
