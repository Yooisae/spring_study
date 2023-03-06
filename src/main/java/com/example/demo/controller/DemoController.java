package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

//    파라미터 받아서 넘기는 코드
    @GetMapping("demo-mvc")
    public String helloMve(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "demo-template";
    }

//    api
    @GetMapping("demo-string")
    @ResponseBody //return 값을 respose body 부분에 직접 넣는다.
    public String demoString(@RequestParam("name") String name){
        return "hello" + name;
    }
//    api

//    객체를 JSON형식으로 넘겨준다.
    @GetMapping("demo-api")
    @ResponseBody
    public Demo demoApi(@RequestParam("name") String name){
        Demo demo = new Demo();
        demo.setName(name);
        return demo;

    }

    static class Demo{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
