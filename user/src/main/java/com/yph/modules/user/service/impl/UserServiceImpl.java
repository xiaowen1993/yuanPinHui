package com.yph.modules.user.service.impl;

import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.mapper.UserMapper;
import com.yph.modules.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yph.util.P;
import com.yph.util.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    UserMapper userMapper;

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
        userEntityNew.setUserLevel(1);
        userEntityNew.setUserMobile(phone);
        try {
            userMapper.insert(userEntityNew);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                //手机号冲突，已经注册
            }
        }
        return null;
    }
}
