package com.spring.professional.exam.tutorial.module05.question02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")  //http://localhost:8080/
    public String index() {
        return "index";
    }
}
