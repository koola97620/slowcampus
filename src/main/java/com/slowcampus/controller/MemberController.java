package com.slowcampus.controller;

import com.slowcampus.dto.Member;
import com.slowcampus.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@Log
public class MemberController {
    private MemberService memberService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupMember() {
        log.info("회원 가입 요청이 수행되었습니다.");
        return "user/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signupMember(Member member) {
        log.info("회원 가입 POST 요청을 Member 객체로 받았습니다.");

        // MemberService로 받는다.
        memberService.signupMember(member);
    }

    @GetMapping("/signin")
    public String signinMember(){
        return "user/signin";
    }

    @PostMapping
    public String signinMember(ModelMap modelMap, @ModelAttribute Member member) {
        if (memberService.loginMember(member) != null) {

            return null;
        }

        return null;
    }
}
