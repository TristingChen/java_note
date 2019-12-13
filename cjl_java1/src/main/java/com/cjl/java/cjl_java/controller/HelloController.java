package com.cjl.java.cjl_java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/helloworld")
    public String hello(){
        return "hello world";
    }
}
