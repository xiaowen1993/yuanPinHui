package com.yph.modules.user.mapper;

import com.yph.modules.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    String selectUserById(Integer userId);

    List<UserEntity> selectUserByReferrer(String upgrade4Id);

    Integer selectSumLifeSource();

    Integer selectSumEnergySource();
}
