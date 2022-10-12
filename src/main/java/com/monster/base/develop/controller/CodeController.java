package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.entity.Code;
import com.monster.base.develop.service.ICodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wuhan
 * @date 2022/9/19 17:05
 */

@RestController
@AllArgsConstructor
@RequestMapping("/code")
@Api(value = "代码生成", tags = "代码生成器")
public class CodeController {

    private ICodeService codeService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Code detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return codeService.getById(id);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public IPage<Code> page(IPage<Code> page, Code code) {
        return codeService.getCodePage(page, code);
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public Boolean submit(@Valid @RequestBody Code code) {
        return codeService.saveOrUpdate(code);
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public Boolean remove(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return codeService.removeById(id);
    }

    @GetMapping("/generator")
    @ApiOperation(value = "代码生成")
    public Boolean codeGenerator(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        codeService.codeGenerator(id);
        return true;
    }
}
