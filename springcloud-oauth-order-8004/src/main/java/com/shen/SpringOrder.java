package com.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringOrder {
    public static void main(String[] args) {
        SpringApplication.run(SpringOrder.class, args);
    }
}
