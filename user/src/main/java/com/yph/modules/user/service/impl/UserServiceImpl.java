package com.yph.modules.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yph.constant.UserConstant;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.mapper.UserMapper;
import com.yph.modules.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import com.yph.util.utli.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private RedisService redisService;



    //用户等级升级
    public void userUpgrade(){
        List<UserEntity> list1=new ArrayList<>();
        List<UserEntity> list2=new ArrayList<>();
        List<UserEntity> list3=new ArrayList<>();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("sum_team_energy_source",20000000);
        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        for (UserEntity userEntity : userEntities) {
            if(userEntity.getUserLevel()==0&&userEntity.getSumTeamEnergySource()>=20000000){
                list1.add(userEntity);
            }else if(userEntity.getUserLevel()==1&&userEntity.getSumTeamEnergySource()>=50000000){
                list2.add(userEntity);
            }else if(userEntity.getUserLevel()==2&&userEntity.getSumTeamEnergySource()>=200000000){
                list3.add(userEntity);
            }else if(userEntity.getUserLevel()==3&&userEntity.getSumTeamEnergySource()>=200000000){
                list3.add(userEntity);
            }else if(userEntity.getUserLevel()==4&&userEntity.getSumTeamEnergySource()>=200000000){
                list3.add(userEntity);
            }else if(userEntity.getUserLevel()==5&&userEntity.getSumTeamEnergySource()>=200000000){
                list3.add(userEntity);
            }
        }
    }

    //累加团队业绩
    @Override
    public Boolean updateSumTeamEnergySource(List<String> userId, String performance) {
        UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.setSql("sum_team_energy_source=sum_team_energy_source"+performance);
        updateWrapper.in("user_id",userId);
        return this.update(updateWrapper);
    }

    @Override
    public String selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }


    @Override
    public R userRegister(P p) throws Exception {
        String phone = p.getString("phone");
        String password = p.getString("password");
        String code = p.getString("code");
        Integer inviterId = p.getInt("inviterId");
        UserEntity userEntityNew=new UserEntity();
        if(inviterId!=null){
            UserEntity userEntity = userMapper.selectById(inviterId);
            if(userEntity==null)
                return R.error("邀请人无效");
            userEntityNew.setUserReferrer(inviterId);
            Integer topRefereeId = userEntity.getTopRefereeId();
            if(topRefereeId!=null)
                userEntityNew.setTopRefereeId(topRefereeId);
            String relation = userEntity.getRelation();
            if(!StringUtils.isBlank(relation))
                userEntity.setRelation(relation+","+inviterId);
        }
        Date date = new Date();
        userEntityNew.setAddTime(date);
        userEntityNew.setUpdateTime(date);
        userEntityNew.setUserPassword(password);
        userEntityNew.setUserLastLoginTime(date);
        userEntityNew.setUserLevel(0);
        userEntityNew.setUserMobile(phone);
        userEntityNew.setFreezeLifeSource(0L);
        userEntityNew.setFreezeEnergySource(0L);
        userEntityNew.setFreezeBean(0L);
        userEntityNew.setLifeSource(0L);
        userEntityNew.setEnergySource(0L);
        userEntityNew.setBean(0L);
        userEntityNew.setGoupSize(0);
        userEntityNew.setUnderlingSize(0);
        userEntityNew.setIndirectSize(0);
        try {
            userMapper.insert(userEntityNew);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                //手机号冲突，已经注册
                return userWithoutLogin(phone);
            }
        }
//        if(inviterId!=null)
//            redisService.getListOperations().leftPush(UserConstant.USER_REGISTER_QUEUE,userEntityNew.getRelation());
        return returnUserData(userEntityNew);
    }

    @Override
    public R userLogin(P p) throws Exception {
        String phone = p.getString("phone");
        String password = p.getString("password");
        String code = p.getString("code");
        if(!StringUtils.isBlank(code)){  //验证码登陆
            //验证 验证码
            //通过查询用户
            UserEntity userEntity = selectPhone(phone);
            return returnUserData(userEntity);
        }else if(!StringUtils.isBlank(password)){  //密码登陆
            UserEntity userEntity = selectPhone(phone);
            if(userEntity.getUserPassword().equals(password)){
                return returnUserData(userEntity);
            }
        }
        return R.error("密码或验证码错误");
    }


    //用户免密登录（用户已经注册的用户，点击注册流程）
    public R userWithoutLogin(String phone) throws Exception {
        UserEntity userEntity = selectPhone(phone);
        return returnUserData(userEntity);
    }

    //根据手机号查询用户
    private UserEntity selectPhone(String phone){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_mobile",phone);
        return userMapper.selectOne(queryWrapper);
    }

    //返回用户信息
    private R returnUserData(UserEntity userEntity) throws Exception {
        String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(userEntity.getUserId()));
        userEntity.setUserId(null);
        return R.success().data(userEntity).set("token",jwt);
    }

}
