package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "helloworld";
    }

    @GetMapping("/welcome")
    public String hellosb() {
        return "helloSpringBoot";
    }
}
