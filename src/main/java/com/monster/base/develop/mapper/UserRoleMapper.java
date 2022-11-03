package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserRoleDTO;
import com.monster.base.develop.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.base.develop.vo.UserRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户角色关联表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 分页查询
     *
     * @param page     分页
     * @param userRole 查询条件
     * @return List<UserRoleVO>
     */
    List<UserRoleVO> getUserRolePage(IPage<UserRoleVO> page, @Param("pm") UserRoleDTO userRole);

}

