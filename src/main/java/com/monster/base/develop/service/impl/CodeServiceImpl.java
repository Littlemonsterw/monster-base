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
        codeGenerator.setUrl("jdbc:mysql://10.10.1.42:3306/sc_community?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        codeGenerator.setUsername("sc");
        codeGenerator.setPassword("Leyun@sc");
        codeGenerator.setSchemaName("c_owner_house");
        codeGenerator.setParentPackage("com.monster.base.develop");
        codeGenerator.setPackageDir("E:\\code");
        codeGenerator.setTablePrefix("c_");
        codeGenerator.setHasSuperEntity(true);
        codeGenerator.run();
    }
}
