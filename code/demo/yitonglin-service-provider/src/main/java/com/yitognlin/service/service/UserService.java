package com.yitognlin.service.service;

import com.yitognlin.service.mapper.UserMapper;
import com.yitognlin.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
