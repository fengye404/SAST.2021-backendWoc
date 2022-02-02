package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String uploadUsername(@RequestBody Account account) {
        return userService.register(account);//
    }

    @PostMapping("/login")
    public String login( @RequestBody Account account) {
        return userService.login(account);
    }

    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     * @param account
     */

    /**
     * 完成登录功能
     * @param account
     * @return 是否登录成功
     */

}


