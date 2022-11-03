package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserRoleDTO;
import com.monster.base.develop.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.monster.base.develop.vo.UserRoleVO;


/**
 * 用户角色关联表 服务类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param userRole 查询条件
     * @return IPage<UserRoleVO>
     */
    IPage<UserRoleVO> getUserRolePage(IPage<UserRoleVO> page, UserRoleDTO userRole);

}
