package com.monster.base.develop.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.monster.base.develop.entity.Dept;


/**
 * 组织信息表 视图实体类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DeptVO对象")
public class DeptVO extends Dept {
    private static final long serialVersionUID = 1L;

}
