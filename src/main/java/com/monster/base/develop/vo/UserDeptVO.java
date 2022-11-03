package com.monster.base.develop.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.monster.base.develop.entity.UserDept;


/**
 * 用户组织关联表 视图实体类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserDeptVO对象")
public class UserDeptVO extends UserDept {
    private static final long serialVersionUID = 1L;

}
