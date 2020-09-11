package com.yitognlin.service.controller;

import com.yitognlin.service.pojo.User;
import com.yitognlin.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @GetMapping("test")
    public String test(@RequestParam("test1")String test1){
        return "test"+test1;
    }


}
