package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据源配置表
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@Data
@TableName("mpg_datasource")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Datasource对象", description = "数据源配置表")
public class Datasource extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "连接地址")
    private String url;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "备注")
    private String remark;
}