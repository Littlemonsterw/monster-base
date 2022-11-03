package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.common.Condition;
import com.monster.base.develop.common.R;
import com.monster.base.develop.dto.DeptDTO;
import com.monster.base.develop.entity.Dept;
import com.monster.base.develop.entity.Query;
import com.monster.base.develop.service.IDeptService;
import com.monster.base.develop.utils.Func;
import com.monster.base.develop.vo.DeptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 组织信息表 控制器
 *
 * @author Monster-w
 * @date 2022-11-03 11:13:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dept")
@Api(value = "组织信息表", tags = "组织信息表接口")
public class DeptController {

    private IDeptService deptService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public R<Dept> detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(deptService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R<IPage<DeptVO>> page(DeptDTO dept, Query query) {
        return R.data(deptService.getDeptPage(Condition.getPage(query), dept));
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public R<Boolean> submit(@Valid @RequestBody Dept dept) {
        return R.data(deptService.saveOrUpdate(dept));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public R<Boolean> remove(@ApiParam(value = "主键ids", required = true) @RequestParam String ids) {
        return R.data(deptService.removeByIds(Func.toLongList(",", ids)));
    }
}