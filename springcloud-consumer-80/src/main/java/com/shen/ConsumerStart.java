package com.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerStart {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStart.class, args);
    }

    @Bean
    @LoadBalanced  // Eureka负载均衡的实现
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
