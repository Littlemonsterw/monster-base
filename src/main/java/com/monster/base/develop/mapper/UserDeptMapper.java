package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserDeptDTO;
import com.monster.base.develop.entity.UserDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.base.develop.vo.UserDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户组织关联表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface UserDeptMapper extends BaseMapper<UserDept> {

    /**
     * 分页查询
     *
     * @param page     分页
     * @param userDept 查询条件
     * @return List<UserDeptVO>
     */
    List<UserDeptVO> getUserDeptPage(IPage<UserDeptVO> page, @Param("pm") UserDeptDTO userDept);

}

