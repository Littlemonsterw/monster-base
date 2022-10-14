package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.dto.CodeDTO;
import com.monster.base.develop.entity.Code;
import com.monster.base.develop.entity.Datasource;
import com.monster.base.develop.mapper.CodeMapper;
import com.monster.base.develop.service.ICodeService;
import com.monster.base.develop.service.IDatasourceService;
import com.monster.base.develop.utils.CodeGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author wuhan
 * @date 2022/9/19 17:16
 */
@Service
public class CodeServiceImpl extends BaseServiceImpl<CodeMapper, Code> implements ICodeService {

    @Resource
    private IDatasourceService datasourceService;

    @Override
    public IPage<Code> getCodePage(IPage<Code> page, CodeDTO code) {
        return page.setRecords(baseMapper.getCodePage(page, code));
    }

    @Override
    public void codeGenerator(Long id) {
        Code code = getById(id);
        Assert.notNull(code, "未查询到代码生成配置");
        Datasource datasource = datasourceService.getById(code.getDatasourceId());
        Assert.notNull(datasource, "未查询到数据源配置");

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.setUrl(datasource.getUrl());
        codeGenerator.setUsername(datasource.getUsername());
        codeGenerator.setPassword(datasource.getPassword());
        codeGenerator.setSchemaName(code.getTableName());
        codeGenerator.setParentPackage(code.getPackageName());
        codeGenerator.setTablePrefix(code.getTablePrefix());
        codeGenerator.setHasSuperEntity(code.getBaseMode());
        codeGenerator.setPackageDir(code.getApiPath());
        codeGenerator.run();
    }
}
