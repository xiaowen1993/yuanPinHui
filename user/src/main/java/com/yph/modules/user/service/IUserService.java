package com.yph.modules.user.service;

import com.yph.modules.user.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yph.util.P;
import com.yph.util.R;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
public interface IUserService extends IService<UserEntity> {

    R userRegister(P p) throws Exception;

    R userLogin(P p) throws Exception;

    void userUpgrade();

    Boolean updateSumTeamEnergySource(List<String> userId, String performance);


    String selectUserById(Integer userId);

    R selectUserBySuperior(P p);

    R selectUserReferrerTo(P p);

    R selectUserReferrerTo(Integer userId);
}
