package com.sikiro.om.api.controller;

import com.sikiro.om.api.dto.user.UserRequest;
import com.sikiro.om.api.dto.user.UserResponse;
import com.sikiro.om.application.service.UserService;
import com.sikiro.om.infrastructure.base.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/user")
@Api
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ApiResult<UserResponse> Login(@RequestBody @Valid UserRequest request) {
        boolean checkReuslt = userService.checkPassword(request.userName, request.password);

        ApiResult<UserResponse> res = ApiResult.Success("操作成功", new UserResponse());
        return checkReuslt ? ApiResult.Success(new UserResponse()) : ApiResult.Failed();
    }
}
