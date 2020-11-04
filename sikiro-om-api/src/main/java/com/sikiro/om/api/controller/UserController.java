package com.sikiro.om.api.controller;

import com.sikiro.om.api.dto.user.UserRequest;
import com.sikiro.om.api.dto.user.UserResponse;
import com.sikiro.om.application.service.UserService;
import com.sikiro.om.infrastructure.base.ServiceResult;
import io.swagger.annotations.*;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/user")
@Api
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ServiceResult<UserResponse> Login(@RequestBody UserRequest request) throws Exception {

        if(true){
            throw new Exception("asdasd");
        }
        boolean checkReuslt = userService.CheckPassword();
        ServiceResult<UserResponse> sr = ServiceResult.Success("",new UserResponse());
        return sr;
    }
}
