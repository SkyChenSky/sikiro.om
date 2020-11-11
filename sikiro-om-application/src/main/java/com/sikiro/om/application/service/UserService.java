package com.sikiro.om.application.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sikiro.om.application.bo.UserBo;
import com.sikiro.om.infrastructure.base.ServiceResult;
import com.sikiro.om.infrastructure.helper.EncodingHelper;
import com.sikiro.om.infrastructure.helper.ModelMapperHelper;
import com.sikiro.om.repository.entity.User;
import com.sikiro.om.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ServiceResult<UserBo> checkPassword(String userName, String password) {
        LambdaQueryWrapper<User> userCondition = Wrappers.<User>lambdaQuery().eq(User::getUserName, userName);
        User user = userMapper.selectOne(userCondition);

        if (user == null) {
            return ServiceResult.Failed("不存在该用户或密码错误");
        } else {
            if (user.getPassword().equals(EncodingHelper.Md5(password))) {

                UserBo userBo = ModelMapperHelper.Map(user, UserBo.class);

                return ServiceResult.Success("密码正确", userBo);
            } else {
                return ServiceResult.Failed("不存在该用户或密码错误");
            }
        }
    }
}

