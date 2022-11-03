package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织信息表
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@TableName("sys_dept")
@ApiModel(value = "Dept对象", description = "组织信息表")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"createDeptId", "createUserId", "createTime", "updateUserId", "updateTime", "isDeleted"})
public class Dept extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父主键id")
    private Long parentId;

    @ApiModelProperty(value = "祖级列表")
    private String ancestors;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}