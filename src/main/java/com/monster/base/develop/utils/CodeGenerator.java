package com.monster.base.develop.utils;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Data;

import java.util.Collections;

/**
 * @author wuhan
 * @date 2022/9/19 16:47
 */
@Data
public class CodeGenerator {

    private String url;
    private String username;
    private String password;
    private String schemaName;

    private String packageDir;
    private String packageWebDir;

    public void run() {

        // 数据库配置
        DataSourceConfig dsc = new DataSourceConfig
                .Builder(url, username, password)
                .schema(schemaName)
                .build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .disableOpenDir()
                .outputDir("")
                .author("")
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate(DatePattern.NORM_DATETIME_PATTERN)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("")
                .moduleName("")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper")
                .controller("controller")
                .build();

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .xml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();

        // 注入配置
        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> {
                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                })
                .customMap(Collections.singletonMap("test", "monster"))
                .customFile(Collections.singletonMap("test.txt", "/templates/test.vm"))
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .likeTable(new LikeTable("USER"))
                .addInclude("t_simple")
                .addTablePrefix("t_", "c_")
                .addFieldSuffix("_flag")
                .build();

        AutoGenerator generator = new AutoGenerator(dsc);
        generator.global(globalConfig);
        generator.packageInfo(packageConfig);
        generator.template(templateConfig);
        generator.injection(injectionConfig);
        generator.strategy(strategyConfig);
        generator.execute();
    }
}
