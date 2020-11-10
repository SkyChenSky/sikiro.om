package com.sikiro.om.repository.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * user
 * @author 陈珙
 */
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId

    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    /**
     * 是否超级管理员
     */
    private byte[] isSuper;

    /**
     * 状态,0停用，1启动
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}