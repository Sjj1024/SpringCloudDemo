package com.shen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("one")
    @PreAuthorize("hasAuthority('r1')")
    @ResponseBody
    public String getOrders() {
        return "这里是订单服务返回的数据啊：111111";
    }

}
