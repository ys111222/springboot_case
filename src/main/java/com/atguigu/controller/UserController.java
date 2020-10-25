package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/findAll")
    public Result findAll(){
        try {
            List<User> userList = userService.findAll();
            return  Result.ok(true,"成功",userList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(false,"失败");
        }
    }
}
