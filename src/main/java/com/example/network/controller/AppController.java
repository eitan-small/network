package com.example.network.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/app")
    public String app() {
        return "forward:/static/index.html"; // 指向Vue.js应用程序的入口HTML文件
    }
}
