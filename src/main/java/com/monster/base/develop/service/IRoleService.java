package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.RoleDTO;
import com.monster.base.develop.entity.Role;
import com.monster.base.develop.vo.RoleVO;


/**
 * 角色表 服务类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface IRoleService extends BaseService<Role> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param role 查询条件
     * @return IPage<RoleVO>
     */
    IPage<RoleVO> getRolePage(IPage<RoleVO> page, RoleDTO role);

}
