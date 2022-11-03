package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserDTO;
import com.monster.base.develop.entity.User;
import com.monster.base.develop.vo.UserVO;


/**
 * 系统用户表 服务类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface IUserService extends BaseService<User> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param user 查询条件
     * @return IPage<UserVO>
     */
    IPage<UserVO> getUserPage(IPage<UserVO> page, UserDTO user);

}
