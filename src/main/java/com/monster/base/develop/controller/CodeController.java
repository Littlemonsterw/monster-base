package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.common.Condition;
import com.monster.base.develop.common.R;
import com.monster.base.develop.common.ResultCode;
import com.monster.base.develop.dto.CodeDTO;
import com.monster.base.develop.entity.Code;
import com.monster.base.develop.entity.Query;
import com.monster.base.develop.service.ICodeService;
import com.monster.base.develop.utils.Func;
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
    public R<Code> detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(codeService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R<IPage<Code>> page(CodeDTO code, Query query) {
        return R.data(codeService.getCodePage(Condition.getPage(query), code));
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public R<Boolean> submit(@Valid @RequestBody Code code) {
        return R.data(codeService.saveOrUpdate(code));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public R<Boolean> remove(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(codeService.removeById(id));
    }

    @GetMapping("/generator")
    @ApiOperation(value = "代码生成")
    public R<Boolean> codeGenerator(@ApiParam(value = "代码主键id集合", required = true) @RequestParam String codeIds) {
        try {
            Func.toLongList(codeIds).forEach(codeId -> codeService.codeGenerator(codeId));
        } catch (Exception e) {
            return R.fail(ResultCode.FAILURE.getCode(), e.getMessage());
        }
        return R.data(true);
    }
}
