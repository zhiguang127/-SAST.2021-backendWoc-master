package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.mapper.UserMapper;
import com.example.woc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/register")
    public String register(String name,String password){
        log.info("name{}",name);
        log.info("password{}",password);
        if(!StringUtils.hasLength(name)){
            return "用户名不得为空";
        }
        if(!StringUtils.hasLength(password)){
            return "密码不得为空";
        }
        Account record= new Account();
        record.setName(name);
        Account user=userMapper.selectOne(record);
        if(user!=null){
            return "注册失败，用户已存在";
        }
        user=new Account();
        user.setName(name);
        user.setPassword(password);
        int resultCount =userMapper.insertSelective(user);

        if(resultCount == 0){
            return "注册失败";
        }

        return "注册成功";
    }

    @GetMapping("/login")
    public String login(String name,String password){
        if(!StringUtils.hasLength(name)){
            return "用户名不得为空";
        }
        if(!StringUtils.hasLength(password)){
            return "密码不得为空";
        }
        Account record=new Account();
        record.setName(name);
        Account user=userMapper.selectOne(record);
        if(user==null){
            return "登录失败";
        }
        if(Objects.equals(password, user.getPassword())){
            return "登录成功";
        }
        return "登录失败";
    }


}


