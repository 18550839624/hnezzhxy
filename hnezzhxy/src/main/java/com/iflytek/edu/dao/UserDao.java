package com.iflytek.edu.dao;

import com.iflytek.edu.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 14512 on 2020/7/10.
 */
@Mapper
public interface UserDao {
    List<User> getUsers(String id);
}
