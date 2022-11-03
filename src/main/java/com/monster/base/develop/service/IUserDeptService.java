package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserDeptDTO;
import com.monster.base.develop.entity.UserDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.monster.base.develop.vo.UserDeptVO;


/**
 * 用户组织关联表 服务类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface IUserDeptService extends IService<UserDept> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param userDept 查询条件
     * @return IPage<UserDeptVO>
     */
    IPage<UserDeptVO> getUserDeptPage(IPage<UserDeptVO> page, UserDeptDTO userDept);

}
