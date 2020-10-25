package com.shen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("服务提供者接口被调用到了！");
        return "你好，我是provider2 的打招呼";
    }

    @RequestMapping("/get/list")
    public List<String> getList() {
        List<String> listStr = new ArrayList<String>();
        listStr.add("shu1   2");
        listStr.add("shu2   2");
        listStr.add("shu3   2");
        return listStr;
    }
}
