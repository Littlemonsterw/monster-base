package com.monster.base.develop.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * @author wuhan
 * @date 2022/9/19 16:47
 */
public class CodeGenerator {

    public void run() {

        FastAutoGenerator.create("url", "username", "password")
                .globalConfig(builder -> builder.author("wuhan")
                        .enableSwagger()
                        .outputDir(""))
                .packageConfig(builder -> builder.moduleName(""))
                .strategyConfig(builder -> builder.addExclude(""))
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }
}
