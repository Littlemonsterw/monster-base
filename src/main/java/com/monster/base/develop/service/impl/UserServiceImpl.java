package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserDTO;
import com.monster.base.develop.entity.User;
import com.monster.base.develop.mapper.UserMapper;
import com.monster.base.develop.service.IUserService;
import com.monster.base.develop.vo.UserVO;
import org.springframework.stereotype.Service;


/**
 * 系统用户表 实现类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<UserVO> getUserPage(IPage<UserVO> page, UserDTO user) {
        return page.setRecords(baseMapper.getUserPage(page, user));
    }

}
