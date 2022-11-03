package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.RoleDTO;
import com.monster.base.develop.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.base.develop.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param role 查询条件
     * @return List<RoleVO>
     */
    List<RoleVO> getRolePage(IPage<RoleVO> page, @Param("pm") RoleDTO role);

}

