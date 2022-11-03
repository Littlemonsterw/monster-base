package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.DeptDTO;
import com.monster.base.develop.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monster.base.develop.vo.DeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 组织信息表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-11-03 10:57:43
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param dept 查询条件
     * @return List<DeptVO>
     */
    List<DeptVO> getDeptPage(IPage<DeptVO> page, @Param("pm") DeptDTO dept);

}

