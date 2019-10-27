package com.cafecostes.cafe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspViewController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
