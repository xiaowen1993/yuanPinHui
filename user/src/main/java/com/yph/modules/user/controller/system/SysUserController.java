package com.yph.modules.user.controller.system;

import com.yph.annotation.PassToken;
import com.yph.annotation.Pmap;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.IUserService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LC
 * 2020-11-23 11:45
 */
@RestController
@RequestMapping("/user/sysUserController")
public class SysUserController {

    @Autowired
    IUserService userService;


    @GetMapping("/list")
    @PassToken
    public R userAll(@Pmap P p){
        return R.success().data(userService.list());
    }

    @PostMapping("/update")
    @PassToken
    public R update(@Pmap P p) throws Exception{
        UserEntity userEntity = p.thisToEntity(UserEntity.class);
        userService.updateById(userEntity);
        return R.success();
    }


}
