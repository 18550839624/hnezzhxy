package com.iflytek.edu.service;

import com.iflytek.edu.dao.UserDao;
import com.iflytek.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 叶清
 * @create 2020-07-10-23:50
 **/
@Service
public class TestService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(String id) {
      return   userDao.getUsers(id);
    }
}
