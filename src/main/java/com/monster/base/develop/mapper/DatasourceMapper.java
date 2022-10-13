package com.monster.base.develop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.base.develop.dto.DatasourceDTO;
import com.monster.base.develop.entity.Datasource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 数据源配置表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
public interface DatasourceMapper extends BaseMapper<Datasource> {

    /**
    * 分页查询
    *
    * @param page 分页
    * @param datasource 查询条件
    * @return List<DatasourceVO>
    */
    List<Datasource> getDatasourcePage(Page<Datasource> page, @Param("pm") DatasourceDTO datasource);

}

