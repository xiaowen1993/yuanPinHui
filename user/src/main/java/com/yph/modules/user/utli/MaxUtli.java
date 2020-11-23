package com.yph.modules.user.utli;

import com.yph.constant.UserConstant;
import com.yph.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MaxUtli {

    @Autowired
    private RedisService redisService;

    public static int MAX_LIFE_SOURCE=5000000;

    public static int MAX_ENERGY_SOURCE=50000000;


    public boolean isMaxLifeSource(String lifeSource){
        String s = redisService.get(UserConstant.SYSTEM_SUM_LIFESOURCE);
        BigDecimal bigDecimal=new BigDecimal(s);
        BigDecimal decimal = bigDecimal.add(new BigDecimal(lifeSource));
        if(decimal.doubleValue()<MAX_LIFE_SOURCE){
            return true;
        }
        return false;
    }


    public boolean isMaxEnergySource(String energySource){
        String s = redisService.get(UserConstant.SYSTEM_SUM_ENERGYSOURCE);
        BigDecimal bigDecimal=new BigDecimal(s);
        BigDecimal decimal = bigDecimal.add(new BigDecimal(energySource));
        if(decimal.doubleValue()<MAX_ENERGY_SOURCE){
            return true;
        }
        return false;
    }

}
