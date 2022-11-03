package com.monster.base.develop.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.monster.base.develop.entity.Role;


/**
 * 角色表 视图实体类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RoleVO对象")
public class RoleVO extends Role {
    private static final long serialVersionUID = 1L;

}
