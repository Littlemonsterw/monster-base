package com.monster.base.develop.controller;

import com.monster.base.develop.service.ICodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/generator")
    @ApiOperation(value = "代码生成")
    public Boolean codeGenerator() {
        codeService.codeGenerator();
        return true;
    }
}
