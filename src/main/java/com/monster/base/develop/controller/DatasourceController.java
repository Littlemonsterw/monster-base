package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.base.develop.dto.DatasourceDTO;
import com.monster.base.develop.entity.Datasource;
import com.monster.base.develop.service.IDatasourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 *
 * 数据源配置表 控制器
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@RestController
@AllArgsConstructor
@RequestMapping("/datasource")
@Api(value = "数据源配置表", tags = "数据源配置表接口")
public class DatasourceController {

    private IDatasourceService datasourceService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Datasource detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return datasourceService.getById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public IPage<Datasource> page(Page<Datasource> page, DatasourceDTO datasource) {
        return datasourceService.getDatasourcePage(page, datasource);
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public Boolean submit(@Valid @RequestBody Datasource datasource) {
        return datasourceService.saveOrUpdate(datasource);
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public Boolean remove(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return datasourceService.removeById(id);
    }
}