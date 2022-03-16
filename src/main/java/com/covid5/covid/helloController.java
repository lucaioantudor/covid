package com.covid5.covid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
    
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        // return new ModelAndView("WEB-INF/hello.jsp");
        return "hello";
    }
}
