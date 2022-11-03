package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.DeptDTO;
import com.monster.base.develop.entity.Dept;
import com.monster.base.develop.mapper.DeptMapper;
import com.monster.base.develop.service.IDeptService;
import com.monster.base.develop.vo.DeptVO;
import org.springframework.stereotype.Service;


/**
 * 组织信息表 实现类
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public IPage<DeptVO> getDeptPage(IPage<DeptVO> page, DeptDTO dept) {
        return page.setRecords(baseMapper.getDeptPage(page, dept));
    }

}
