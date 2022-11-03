package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monster.base.develop.dto.UserDeptDTO;
import com.monster.base.develop.entity.UserDept;
import com.monster.base.develop.mapper.UserDeptMapper;
import com.monster.base.develop.service.IUserDeptService;
import com.monster.base.develop.vo.UserDeptVO;
import org.springframework.stereotype.Service;


/**
 * 用户组织关联表 实现类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Service
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements IUserDeptService {

    @Override
    public IPage<UserDeptVO> getUserDeptPage(IPage<UserDeptVO> page, UserDeptDTO userDept) {
        return page.setRecords(baseMapper.getUserDeptPage(page, userDept));
    }

}
