package com.yph.modules.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yph.annotation.PassToken;
import com.yph.annotation.Pmap;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.execute.LifeSourceExecute;
import com.yph.modules.user.service.IUserService;
import com.yph.util.P;
import com.yph.util.R;
import com.yph.util.utli.ValidateUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
     * 查询用户信息
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectUserById")
    public R selectUserById(@Pmap P p) throws Exception {
        return userService.getUserById(p);
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

    @Autowired
    LifeSourceExecute lifeSourceExecute;

    //添加省市区代理
    @PassToken
    @RequestMapping("/addZoneCode")
    public R addZoneCode(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"zoneCode","rank","userId");
        return userService.addZoneCode(p);
    }


    //生命源互转
    @RequestMapping("/lifeSourceToLifeSource")
    public R lifeSourceToLifeSource(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"size");
        return userService.lifeSourceToLifeSource(p);
    }


    //添加生命源
    @RequestMapping("/addLifeSource")
    public R addLifeSource(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"size");
        return userService.addLifeSource(p);
    }

    //生命源转为能量源
    @RequestMapping("/lifeSourceToEnergySource")
    public R lifeSourceToEnergySource(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"lifeSource");
        return userService.lifeSourceToEnergySource(p);
    }


    //能量源转为币
    @RequestMapping("/energySourceToBean")
    public R energySourceToBean(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"energySource");
        return userService.energySourceToBean(p);
    }

    //能量源转为生命源
    @RequestMapping("/energySourceToLifeSource")
    public R energySourceToLifeSource(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"energySource");
        return userService.energySourceToLifeSource(p);
    }


    //币转为能量源
    @RequestMapping("/beanToEnergySource")
    public R beanToEnergySource(@Pmap P p) throws Exception {
        ValidateUtli.validateParams(p,"bean");
        return userService.beanToEnergySource(p);
    }

    @RequestMapping("/test")
    public R test(){
        lifeSourceExecute.LifeSourceToEnergy();
        return R.success();
    }


    @RequestMapping("/getRankAndZoneCode")
    @PassToken
    public R getRankAndZoneCode(@Pmap P p){
        Map<String,Object> map=new HashMap<>();
        List<UserEntity> rank=userService.list(new QueryWrapper<UserEntity>().select("rank").isNotNull("zone_code").groupBy("rank"));
        for (UserEntity userEntity : rank) {
            List<UserEntity> list=userService.list(new QueryWrapper<UserEntity>().select("rank","zone_code").isNotNull("zone_code").eq("rank",userEntity.getRank()));
            map.put(userEntity.getRank().toString(),list);
        }
        return R.success().data(map);
    }


    @RequestMapping("/isAdmin")
    @PassToken
    public R isAdmin(@Pmap P p){
        QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("is_admin",1);
        return R.success().data(userService.list(queryWrapper));
    }


}
