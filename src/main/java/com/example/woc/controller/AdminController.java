package com.example.woc.controller;

import com.example.woc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.woc.entity.Account;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 04:19
 **/
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String login(@RequestBody Account account){
        return userService.login(account);//account.getUsername(), account.getPassword()
    }

    @PostMapping("/register")
    public String register(@RequestBody Account account){
        return userService.register(account);//account.getUsername(), account.getPassword(),account.getEmail()
    }
    @PutMapping("/deleteAccount")
    public String deleteAccount(@RequestBody Account account) {
        return userService.deleteAccount(account);//account.getUsername(), account.getPassword()
    }
    /**
     * 获取当前的账户总数
     * @return
     */
    @GetMapping("/getAmount")
    public List<Account> getAmountOfAccounts(){

        return userService.getAmountOfAccounts();
    }


    //请仿照 User 补充 Admin 的三层架构并完成接口
    /**
     * 获取当前的账户总数
     * @return
     */

    /**
     * 根据用户名删除账户
     * @param username
     */

}
