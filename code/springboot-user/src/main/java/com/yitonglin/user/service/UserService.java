package com.yitonglin.user.service;

import com.yitonglin.user.mapper.UserMapper;
import com.yitonglin.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteUserById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public List<User> findAll() {
        List<User> list = this.userMapper.selectAll();
        return list;
    }
}
