package com.sikiro.om.api.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserRequest {

    @ApiModelProperty(value = "用户名")
    public String userName;

    @ApiModelProperty(value = "密码")
    public String password;
}
