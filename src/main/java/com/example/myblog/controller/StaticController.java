package com.example.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/articles/privacy")
    public String privacy(Model model) {
        model.addAttribute("privacy_msg", "테스트용 개인정보 보호정책 페이지입니다.");
        return "articles/privacy";
    }

    @GetMapping("/articles/terms")
    public String terms(Model model) {
        model.addAttribute("terms_msg", "약관 페이지입니다.");
        return "articles/terms";
    }
}
