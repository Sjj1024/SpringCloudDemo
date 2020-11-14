package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserControl {

    @RequestMapping("one")
    @ResponseBody
    public String getUser() {
        return "你好啊，我是用户接口";
    }


}
