package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户组织关联表
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@TableName("sys_user_dept")
@ApiModel(value = "UserDept对象", description = "用户组织关联表")
public class UserDept implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "组织id")
    private Long deptId;
}