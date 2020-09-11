package com.yitonglin.user.controller;

import com.yitonglin.user.pojo.User;
import com.yitonglin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    @ResponseBody
    public String  test(){
        return "hello world!";
    }

    //此处写法为占位符 取值为@PathVariable("id")  若为？后的值则使用getparam取
    @GetMapping("{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id")long id){
        return userService.findUserById(id);
    }

    @GetMapping("findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "users";

    }
}
