package com.iflytek.edu.controller;

import com.iflytek.edu.model.User;
import com.iflytek.edu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 叶清
 * @create 2020-07-10-23:50
 **/
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public List<User> getUsers(String id){
        System.out.println("大赛打算多多");
           return  testService.getUsers(id);
    }
}
