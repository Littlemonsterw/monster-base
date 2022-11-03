package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.RoleDTO;
import com.monster.base.develop.entity.Role;
import com.monster.base.develop.mapper.RoleMapper;
import com.monster.base.develop.service.IRoleService;
import com.monster.base.develop.vo.RoleVO;
import org.springframework.stereotype.Service;


/**
 * 角色表 实现类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public IPage<RoleVO> getRolePage(IPage<RoleVO> page, RoleDTO role) {
        return page.setRecords(baseMapper.getRolePage(page, role));
    }

}
