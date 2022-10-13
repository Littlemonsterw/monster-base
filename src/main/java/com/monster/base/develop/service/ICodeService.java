package com.monster.base.develop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.base.develop.dto.CodeDTO;
import com.monster.base.develop.entity.Code;

/**
 * @author wuhan
 * @date 2022/9/19 17:14
 */
public interface ICodeService extends BaseService<Code> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param code 查询条件
     * @return IPage<CodeVO>
     */
    IPage<Code> getCodePage(Page<Code> page, CodeDTO code);

    /**
     * 代码生成
     *
     * @param id 代码生产表主键id
     */
    void codeGenerator(Long id);
}
