package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.UserDTO;
import com.monster.base.develop.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.base.develop.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 系统用户表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param user 查询条件
     * @return List<UserVO>
     */
    List<UserVO> getUserPage(IPage<UserVO> page, @Param("pm") UserDTO user);

}

