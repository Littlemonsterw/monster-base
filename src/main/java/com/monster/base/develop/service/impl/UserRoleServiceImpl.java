package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monster.base.develop.dto.UserRoleDTO;
import com.monster.base.develop.entity.UserRole;
import com.monster.base.develop.mapper.UserRoleMapper;
import com.monster.base.develop.service.IUserRoleService;
import com.monster.base.develop.vo.UserRoleVO;
import org.springframework.stereotype.Service;


/**
 * 用户角色关联表 实现类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public IPage<UserRoleVO> getUserRolePage(IPage<UserRoleVO> page, UserRoleDTO userRole) {
        return page.setRecords(baseMapper.getUserRolePage(page, userRole));
    }

}
