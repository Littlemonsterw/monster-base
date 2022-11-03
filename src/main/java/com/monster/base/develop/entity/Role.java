package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@TableName("sys_role")
@ApiModel(value = "Role对象", description = "角色表")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"createDeptId", "createUserId", "createTime", "updateUserId", "updateTime", "isDeleted"})
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父权限id")
    private Long parentId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "角色说明")
    private String description;

    @ApiModelProperty(value = "状态 0-启用，1-禁用")
    private Integer status;
}