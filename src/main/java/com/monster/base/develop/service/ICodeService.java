package com.monster.base.develop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monster.base.develop.entity.Code;

/**
 * @author wuhan
 * @date 2022/9/19 17:14
 */
public interface ICodeService extends IService<Code> {

    void codeGenerator();
}
