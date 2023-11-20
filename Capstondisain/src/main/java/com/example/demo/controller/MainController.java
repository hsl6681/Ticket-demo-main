package com.example.demo.controller;

import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/main")
    public String main(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        MemberEntity loginUser = memberService.getLoginUserByMno(userId);
        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
        }

        return "/main";
    }
}


