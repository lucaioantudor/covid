package com.covid5.covid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    //redirects to hello.jsp
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    //redirects home address to index.jsp
    @RequestMapping("/")
    public String home(){
        System.out.println("index");
        return "index";
    }
}
