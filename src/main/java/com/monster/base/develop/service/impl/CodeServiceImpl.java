package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monster.base.develop.entity.Code;
import com.monster.base.develop.mapper.CodeMapper;
import com.monster.base.develop.service.ICodeService;
import org.springframework.stereotype.Service;

/**
 * @author wuhan
 * @date 2022/9/19 17:16
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements ICodeService {
}
