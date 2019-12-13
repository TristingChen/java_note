package com.cjl.java.cjl_java.controller;

import com.cjl.java.cjl_java.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "{id}",produces = "application/json;charset=utf-8")
    public User getUser(@PathVariable("id") Long id){
        User aa = new User(id,"小明",22);
        System.out.println(aa);
        return aa;
    }
}
