package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.base.develop.dto.DatasourceDTO;
import com.monster.base.develop.entity.Datasource;


/**
 * 数据源配置表 服务类
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
public interface IDatasourceService extends BaseService<Datasource> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param datasource 查询条件
     * @return IPage<DatasourceVO>
     */
    IPage<Datasource> getDatasourcePage(Page<Datasource> page, DatasourceDTO datasource);

}
