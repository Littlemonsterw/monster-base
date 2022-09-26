package com.monster.base.develop.utils;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.monster.base.develop.entity.BaseEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * @author wuhan
 * @date 2022/9/19 16:47
 */
@Data
@Slf4j
public class CodeGenerator {

    private String url = "jdbc:mysql://10.10.1.42:3306/sc_cabinet?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private String username = "sc";
    private String password = "Leyun@sc";
    private String schemaName = "t_consign_order";

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
                .outputDir("G://code")
                .author("monster-w")
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate(DatePattern.NORM_DATETIME_PATTERN)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.monster")
                .moduleName("")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper")
                .controller("controller")
                .build();

        // 注入配置
        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> log.info("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size()))
                .customMap(Collections.singletonMap("test", "monster"))
                .customFile(Collections.singletonMap("test.txt", "/templates/test.vm"))
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableSchema()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .addExclude(schemaName)
                .addTablePrefix("t_", "c_")
                .addFieldSuffix("_flag")
                .build();

        // 实体属性配置
        strategyConfig.entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)
                .superClass(BaseEntity.class)
                .enableLombok()
                .enableTableFieldAnnotation()
                .enableFileOverride()
                .formatFileName("%sEntity")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                .build();
        // 控制器属性配置
        strategyConfig.controllerBuilder()
                .enableFileOverride()
                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sController")
                .build();
        // Service属性配置
        strategyConfig.serviceBuilder()
                .enableFileOverride()
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .build();
        // Mapper属性配置
        strategyConfig.mapperBuilder()
                .enableBaseResultMap()
                .enableFileOverride()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .build();

        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .xml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();

        AutoGenerator generator = new AutoGenerator(dsc);
        generator.global(globalConfig);
        generator.packageInfo(packageConfig);
//        generator.injection(injectionConfig);
        generator.strategy(strategyConfig);
        generator.template(templateConfig);
        generator.execute();
    }
}
