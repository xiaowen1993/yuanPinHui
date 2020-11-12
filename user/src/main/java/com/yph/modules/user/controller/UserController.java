package com.yph.modules.user.controller;


import com.yph.annotation.Pmap;
import com.yph.modules.user.service.IUserService;
import com.yph.util.P;
import com.yph.util.R;
import com.yph.util.utli.ValidateUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    IUserService userService;


    /**
     *  String phone  手机号
     *  String password  密码
     *  String code    验证码
     *  String inviterId 邀请人ID
     */
    //用户注册
    @RequestMapping("/userRegister")
    public R userRegister(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"phone","password","code");
        return  userService.userRegister(p);
    }


}
