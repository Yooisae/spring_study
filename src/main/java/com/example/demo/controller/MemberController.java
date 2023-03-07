package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    //여러가지 방법이 있는데 Constructor 방법이 가장 좋다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
