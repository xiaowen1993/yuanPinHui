package com.yph.enun;

import com.yph.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Agu
 */
@Component
public class SystemParameter {


    @Autowired
    RedisService redisService;

    //生命源转换能量源的比率
    public  BigDecimal LifeSourceToEEnergyRate;

    //直推
    public  BigDecimal directPush;
   //  间推
    public  BigDecimal indirectPush;

    /**
     * 得到所有的值
     * @return
     */
    public Map getSystemParameterAll(){
        return redisService.get("SystemParameter", HashMap.class);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void AddOrUpdateSystemParameter(String key,Object value){
        Map<String,Object> systemParameterAll=getSystemParameterAll();
        systemParameterAll.put(key,value);
        redisService.set("SystemParameter",systemParameterAll);
    }

    public void delete(String key){
        Map<String,Object> systemParameterAll=getSystemParameterAll();
        systemParameterAll.remove(key);
        redisService.set("SystemParameter",systemParameterAll);
    }



    public BigDecimal getLifeSourceToEEnergyRate() {
        Map systemParameterAll = getSystemParameterAll();
        return new BigDecimal(systemParameterAll.get("LifeSourceToEEnergyRate").toString());

    }


    public void setLifeSourceToEEnergyRate(BigDecimal lifeSourceToEEnergyRate) {
        AddOrUpdateSystemParameter("LifeSourceToEEnergyRate",lifeSourceToEEnergyRate);
    }

    public BigDecimal getDirectPush() {
        Map systemParameterAll = getSystemParameterAll();
        return new BigDecimal(systemParameterAll.get("directPush").toString());

    }

    public void setDirectPush(BigDecimal directPush) {
        AddOrUpdateSystemParameter("directPush",directPush);
    }

    public BigDecimal getIndirectPush() {
        Map systemParameterAll = getSystemParameterAll();
        return new BigDecimal(systemParameterAll.get("indirectPush").toString());

    }

    public void setIndirectPush(BigDecimal indirectPush) {
        AddOrUpdateSystemParameter("indirectPush",indirectPush);
    }
}
