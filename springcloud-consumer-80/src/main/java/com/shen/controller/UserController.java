package com.shen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    // private static final String REST_FUL_URL = "http://localhost:8001";

    //  使用ribbon实现负载均衡的时候，从服务器上选择的时候，应该使用服务的名称来获取
    private static final String REST_FUL_URL = "http://PROVIDER";

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("服务消费者/hello接口执行到了");
        return restTemplate.getForObject(REST_FUL_URL + "/hello", String.class);
    }

    @RequestMapping("/get/list")
    public List<String> getList() {
        System.out.println("服务消费者/get/list接口执行到了");
        return restTemplate.getForObject(REST_FUL_URL + "/get/list", List.class);
    }
}
