package com.yph.modules.user.controller;


import com.yph.annotation.PassToken;
import com.yph.annotation.Pmap;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.IUserService;
import com.yph.util.P;
import com.yph.util.R;
import com.yph.util.utli.ValidateUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
     *发送验证码
     */
    @PassToken
    @PostMapping("/sendNote")
    public R sendNote(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"phone");
        p.put("templateCode","SMS_200455393");
        return userService.sendNote(p);
    }


    /**
     *  String phone  手机号
     *  String password  密码
     *  String code    验证码
     *  String inviterId 邀请人ID
     */
    //用户注册
    @PassToken
    @RequestMapping("/userRegister")
    public R userRegister(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"phone","password","code","inviterId");
        return  userService.userRegister(p);
    }


    //根据用户id查询推荐人和推荐人的推荐人
    @RequestMapping("/selectUserReferrerTo")
    public R selectUserReferrerTo(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"userId");
        return userService.selectUserReferrerTo(p);
    }

    //用户登录
    @PassToken
    @RequestMapping("/userLogin")
    public R userLogin(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"phone");
        return  userService.userLogin(p);
    }


    //查询用户上级所有V1-V6  或者指定以上级别(内部调用)
    @RequestMapping("/selectUserBySuperior")
    public R selectUserBySuperior(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"userId");
        return userService.selectUserBySuperior(p);
    }


    //添加省市区代理
    @PassToken
    @RequestMapping("/addZoneCode")
    public R addZoneCode(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"zoneCode","rank");
        return userService.addZoneCode(p);
    }



}
