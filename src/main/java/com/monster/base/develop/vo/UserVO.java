package com.monster.base.develop.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.monster.base.develop.entity.User;


/**
 * 系统用户表 视图实体类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserVO对象")
public class UserVO extends User {
    private static final long serialVersionUID = 1L;

}
