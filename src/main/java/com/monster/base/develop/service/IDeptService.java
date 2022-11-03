package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.DeptDTO;
import com.monster.base.develop.entity.Dept;
import com.monster.base.develop.vo.DeptVO;


/**
 * 组织信息表 服务类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface IDeptService extends BaseService<Dept> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param dept 查询条件
     * @return IPage<DeptVO>
     */
    IPage<DeptVO> getDeptPage(IPage<DeptVO> page, DeptDTO dept);

}
