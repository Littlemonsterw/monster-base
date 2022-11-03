package com.monster.base.develop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.base.develop.common.Condition;
import com.monster.base.develop.common.R;
import com.monster.base.develop.dto.UserDTO;
import com.monster.base.develop.entity.Query;
import com.monster.base.develop.entity.User;
import com.monster.base.develop.service.IUserService;
import com.monster.base.develop.utils.Func;
import com.monster.base.develop.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 系统用户表 控制器
 *
 * @author Monster-w
 * @date 2022-11-03 11:13:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "系统用户表", tags = "系统用户表接口")
public class UserController {

    private IUserService userService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public R<User> detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(userService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R<IPage<UserVO>> page(UserDTO user, Query query) {
        return R.data(userService.getUserPage(Condition.getPage(query), user));
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public R<Boolean> submit(@Valid @RequestBody User user) {
        return R.data(userService.saveOrUpdate(user));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public R<Boolean> remove(@ApiParam(value = "主键ids", required = true) @RequestParam String ids) {
        return R.data(userService.removeByIds(Func.toLongList(ids)));
    }
}