package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.entity.Admin;
import com.example.woc.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("/admin")
@RestController

public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/getAmount")
    public int all(){
        Account record=new Account();
        return adminMapper.selectCount(record);
    }

    @GetMapping("allByName")
    public List<Account> all(String name){
        Account record=new Account();
        record.setName(name);
        return adminMapper.select(record);
    }

    @GetMapping("deleteAccount")
    public int delete(String name){
        Account record=new Account();
        record.setName(name);
        return adminMapper.delete(record);
    }

}
