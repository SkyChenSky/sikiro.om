package com.sikiro.om.application.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sikiro.om.repository.entity.User;
import com.sikiro.om.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean checkPassword(String userName,String password) {
        LambdaQueryWrapper<User> userCondition =  Wrappers.<User>lambdaQuery().eq(User::getUserName,userName).eq(User::getPassword,password);

        User user = userMapper.selectOne(userCondition);

        return user != null;
    }

}

