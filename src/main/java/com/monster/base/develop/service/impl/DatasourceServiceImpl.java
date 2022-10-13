package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.base.develop.dto.DatasourceDTO;
import com.monster.base.develop.entity.Datasource;
import com.monster.base.develop.mapper.DatasourceMapper;
import com.monster.base.develop.service.IDatasourceService;
import org.springframework.stereotype.Service;


/**
 * 数据源配置表 实现类
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@Service
public class DatasourceServiceImpl extends BaseServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

    @Override
    public IPage<Datasource> getDatasourcePage(Page<Datasource> page, DatasourceDTO datasource) {
        return page.setRecords(baseMapper.getDatasourcePage(page, datasource));
    }

}
