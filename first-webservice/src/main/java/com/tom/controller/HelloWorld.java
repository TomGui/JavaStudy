package com.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorld {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "hello world!";
    }
}
