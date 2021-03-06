package com.yph.modules.user.listener;

import com.rabbitmq.client.Channel;
import com.yph.enun.MqParameterEnum;
import com.yph.enun.SystemParameter;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.IUserService;
import com.yph.paramter.MqParamter;
import com.yph.util.BigDecimalUtil;
import com.yph.util.JSONUtils;
import com.yph.util.MqUtil;
import com.yph.util.P;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 团队业绩统计队列
 */
@Component
public class TeamEnergySumListener {


    @Autowired
    MqUtil mqUtil;

    @Autowired
    IUserService userService;

    @Autowired
    SystemParameter systemParameter;

    @RabbitListener(queues = MqParamter.TEAM_ENERGY_SUM_QUEUE)
    public  void  get(Message message, Channel channel) throws Exception{
        List<String> ids=new ArrayList<>();
        System.out.println("aaaaaaaaaaaaaaa");
        //energySource , toUserId , marking(是加还是减) 0加  1减
        Map<String,Object> data = JSONUtils.toMap(new String(message.getBody()));
        P p=new P(data);
        String toUserId = p.getString("toUserId");
        ids.add(toUserId);
        String energySource = p.getString("energySource");
        BigDecimal bigDecimal = BigDecimalUtil.multiply100(energySource);
        BigDecimal multiply = bigDecimal.multiply(systemParameter.getLifeSourceToEEnergyRate());
        energySource=multiply.toString();
        String marking = p.getString("marking");
        if(marking.equals("1")){
            energySource="-"+energySource;
        }else{
            energySource="+"+energySource;
        }
        List<String> strings = updateUserSumTeamEnergySource(toUserId, energySource);//此处不知道乘以多少，这个值是动态的
        mqUtil.testSend(MqParameterEnum.LevelUp.getExchangeName(),MqParameterEnum.LevelUp.getExchangeKeyName(),strings);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


    private List<String> updateUserSumTeamEnergySource(String toUserId,String energySource){
        UserEntity userEntity = userService.getById(toUserId);
        String relation = userEntity.getRelation();
        if(StringUtils.isBlank(relation)){
            return null;
        }
        String[] split = relation.split(",");
        List<String> strings=new ArrayList<>();
        for (String s : split) {
            strings.add(s);
        }
        strings.add(toUserId);  //加上自己
        userService.updateSumTeamEnergySource(strings,energySource);
        return strings;
    }



}
