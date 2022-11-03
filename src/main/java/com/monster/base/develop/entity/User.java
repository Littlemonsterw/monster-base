package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 系统用户表
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@TableName("sys_user")
@ApiModel(value = "User对象", description = "系统用户表")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"createDeptId", "createUserId", "createTime", "updateUserId", "updateTime", "isDeleted"})
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号")
    private String code;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "真实名称")
    private String realName;

    @ApiModelProperty(value = "身份证号")
    private String identityCardNo;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "性别 0-男，1-女")
    private Integer sex;

    @ApiModelProperty(value = "状态 0-启用，1-禁用")
    private Integer status;

    @ApiModelProperty(value = "账户类型 1-永久账号，2-临时账号")
    private Integer accountType;

    @ApiModelProperty(value = "失效时间")
    private LocalDateTime invalidTime;
}