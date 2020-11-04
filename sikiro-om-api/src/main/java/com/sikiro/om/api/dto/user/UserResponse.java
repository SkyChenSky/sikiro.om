package com.sikiro.om.api.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResponse {

    @ApiModelProperty(value = "用户主键")
    public String userId;

    @ApiModelProperty(value = "用户名")
    public String userName;
}
