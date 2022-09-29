package com.monster.base.develop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wuhan
 * @date 2022/9/19 17:07
 */
@Data
@TableName("code")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Code对象", description = "")
public class Code extends BaseEntity {

    @ApiModelProperty(value = "ces")
    private String test;
}
