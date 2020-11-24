package com.yph.modules.user.execute.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yph.constant.UserConstant;
import com.yph.entity.AllocationDto;
import com.yph.enun.MqParameterEnum;
import com.yph.enun.SystemParameter;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.execute.LifeSourceExecute;
import com.yph.modules.user.service.IUserService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.MqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Agu
 */
@Component
public class SystemLifeSourceExecute implements LifeSourceExecute {

    @Autowired
    IUserService userService;


    @Autowired
    MqUtil mqUtil;

    @Autowired
    SystemParameter systemParameter;


    @Autowired
    RedisService redisService;

    @Override
    public void LifeSourceToEnergy() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper();
        queryWrapper.gt("life_source",0);
        List<UserEntity> list = userService.list(queryWrapper);
        //拿到所有生命源大于1的用户
        for (UserEntity userEntity : list) {
            //生命源转化为能量源
            Long lifeSource = userEntity.getLifeSource();
            BigDecimal lifeBig = new BigDecimal(lifeSource.toString());
            //生命源转化成的能量源
            BigDecimal energy ;
            try {
                energy  = lifeBig.multiply(systemParameter.getLifeSourceToEEnergyRate()).setScale(0);
            }catch (ArithmeticException e){
                //小于0
                energy = new BigDecimal("0");
            }
            if (energy.doubleValue()>0){
                UpdateWrapper<UserEntity> userEntityUpdateWrapper =
                        new UpdateWrapper<UserEntity>().setSql("energy_source=energy_source+"+energy.longValue()).eq("user_id",userEntity.getUserId());
                boolean update = userService.update(userEntityUpdateWrapper);
                System.out.println("111");
                if (update){

                    AllocationDto allocationDto = new AllocationDto(userEntity.getUserId(),energy.longValue(),userEntity.getUserLevel());
                    //发送给伞下分成处理
                    mqUtil.testSend(MqParameterEnum.AllocationQueue.getExchangeName(),MqParameterEnum.AllocationQueue.getExchangeKeyName(),allocationDto);
                }
            }
        }
        before();
    }


    @Override
    public void before() {
        begin();


        end();
    }

    public void begin(){
        redisService.getValueOperations().set(UserConstant.SYSTEM_SYNC_ENERGY_SOURCE,"1",5, TimeUnit.MINUTES);
    }

    public  void end(){
        redisService.remove(UserConstant.SYSTEM_SYNC_ENERGY_SOURCE);
    }

}
