package com.monster.base.develop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monster.base.develop.entity.Code;
import com.monster.base.develop.mapper.CodeMapper;
import com.monster.base.develop.service.ICodeService;
import com.monster.base.develop.utils.CodeGenerator;
import org.springframework.stereotype.Service;

/**
 * @author wuhan
 * @date 2022/9/19 17:16
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements ICodeService {

    @Override
    public void codeGenerator() {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.setUrl("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        codeGenerator.setUsername("root");
        codeGenerator.setPassword("root");
        codeGenerator.setSchemaName("system_user");
        codeGenerator.setParentPackage("base");
        codeGenerator.setPackageDir("E:\\code");
        codeGenerator.setTablePrefix("t_");
        codeGenerator.run();
    }
}
