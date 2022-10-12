package com.monster.base.develop.utils;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.monster.base.develop.entity.BaseEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wuhan
 * @date 2022/9/19 16:47
 */
@Data
@Slf4j
public class CodeGenerator {
    private String url;
    private String username;
    private String password;
    private String schemaName;
    private String parentPackage;
    private String moduleName;
    private String tablePrefix;
    private String[] superEntityColumns;
    private String packageDir;
    private String packageWebDir;
    private boolean hasSuperEntity;

    public void run() {
        Properties prop = this.getProperties();
        String outputDir = this.getOutputDir();
        String author = prop.getProperty("author");
        String defaultUrl = prop.getProperty("spring.datasource.url");
        String defaultUserName = prop.getProperty("spring.datasource.username");
        String defaultPassword = prop.getProperty("spring.datasource.password");

        // 数据库配置
        DataSourceConfig dsc = new DataSourceConfig
                .Builder(StringUtils.isBlank(url) ? defaultUrl : url,
                StringUtils.isBlank(username) ? defaultUserName : username,
                StringUtils.isBlank(password) ? defaultPassword : password)
                .build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .disableOpenDir()
                .outputDir(outputDir)
                .author(author)
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate(DatePattern.NORM_DATETIME_PATTERN)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(parentPackage)
                .moduleName(moduleName)
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper")
                .controller("controller")
                .build();

        // 注入配置
        List<CustomFile> customFiles = new ArrayList<>();
        customFiles.add(new CustomFile.Builder()
                .enableFileOverride()
                .fileName("VO.java")
                .templatePath("/templates/entityVO.java.vm")
                .filePath(this.getOutputDir() + "/" + parentPackage.replace(StringPool.DOT, StringPool.SLASH) + "/vo")
                .build());

        customFiles.add(new CustomFile.Builder()
                .enableFileOverride()
                .fileName("DTO.java")
                .templatePath("/templates/entityDTO.java.vm")
                .filePath(this.getOutputDir() + "/" + parentPackage.replace(StringPool.DOT, StringPool.SLASH) + "/dto")
                .build());

        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .customFile(customFiles)
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableSchema()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .addInclude(schemaName)
                .addTablePrefix(tablePrefix)
                .build();

        // 实体属性配置
        strategyConfig.entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)
                .enableLombok()
                .enableTableFieldAnnotation()
                .enableFileOverride()
                .formatFileName("%s")
                .build();

        if (hasSuperEntity) {
            strategyConfig.entityBuilder()
                    .superClass(BaseEntity.class)
                    .addSuperEntityColumns("id", "create_user_id", "update_user_id", "create_time", "update_time", "is_deleted")
                    .build();
        }

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
        generator.injection(injectionConfig);
        generator.strategy(strategyConfig);
        generator.template(templateConfig);
        generator.execute();
    }

    private Properties getProperties() {
        Resource resource = new ClassPathResource("/templates/code.properties");
        Properties properties = new Properties();
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ioException) {
            log.error("获取资源文件出错", ioException);
        }
        return properties;
    }

    private String getOutputDir() {
        String defaultPackageDir = System.getProperty("user.dir");
        return StringUtils.isBlank(this.packageDir) ? defaultPackageDir : this.packageDir;
    }
}
