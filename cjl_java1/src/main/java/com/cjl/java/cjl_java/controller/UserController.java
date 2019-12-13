package com.cjl.java.cjl_java.controller;

import com.cjl.java.cjl_java.domain.User;
import com.cjl.java.cjl_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/userlist")
    public ModelAndView userList(Model model){
        model.addAttribute("userList",userRepository.userList());
        model.addAttribute("title","用户管理");
        return  new ModelAndView("user/list","userModel",model);
    }

    //根据id 查询用户
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user= userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("user/view" ,"userModel",model);
    }
    //获取创建表单页面
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("user/form","userModel",model);
    }

    //保存用户
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user =userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect");
    }

    //根据id删除用户
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/user");
    }

    //修改用户界面
    @GetMapping(value = "edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id,Model model){
        User user =userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","编辑用户");
        return new ModelAndView("user/form" ,"userModel",model);
    }

    @RequestMapping(value = "{id}",produces = "application/json;charset=utf-8")
    public User getUser(@PathVariable("id") Long id){
        User aa = new User(id,"小明",22);
        return aa;
    }
}
