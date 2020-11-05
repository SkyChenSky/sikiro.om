package com.sikiro.om.api.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Data
public class UserRequest {

    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank(message = "请输入用户名")
    public String userName;

    @ApiModelProperty(value = "密码",required = true)
    @NotBlank(message = "请输入密码")
    public String password;
}
