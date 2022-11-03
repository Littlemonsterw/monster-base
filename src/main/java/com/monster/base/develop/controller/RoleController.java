package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.common.Condition;
import com.monster.base.develop.common.R;
import com.monster.base.develop.dto.RoleDTO;
import com.monster.base.develop.entity.Query;
import com.monster.base.develop.entity.Role;
import com.monster.base.develop.service.IRoleService;
import com.monster.base.develop.utils.Func;
import com.monster.base.develop.vo.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 *
 * 角色表 控制器
 *
 * @author Monster-w
 * @date 2022-11-03 11:13:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role")
@Api(value = "角色表", tags = "角色表接口")
public class RoleController {

    private IRoleService roleService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public R<Role> detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(roleService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R<IPage<RoleVO>> page(RoleDTO role, Query query) {
        return R.data(roleService.getRolePage(Condition.getPage(query), role));
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public R<Boolean> submit(@Valid @RequestBody Role role) {
        return R.data(roleService.saveOrUpdate(role));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public R<Boolean> remove(@ApiParam(value = "主键ids", required = true) @RequestParam String ids) {
        return R.data(roleService.removeByIds(Func.toLongList(ids)));
    }
}