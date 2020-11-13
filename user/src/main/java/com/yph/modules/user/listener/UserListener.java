package com.yph.modules.user.listener;

import com.rabbitmq.client.Channel;
import com.yph.modules.user.service.IUserService;
import com.yph.paramter.MqParamter;
import com.yph.util.JSONUtils;
import com.yph.util.P;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class UserListener {


    @Autowired
    IUserService userService;


    @RabbitListener(queues = MqParamter.USER_QUEUE_NAME)
    public  void get(Message message, Channel channel) throws Exception{
        Map<String,Object>  map = JSONUtils.toMap(new String(message.getBody()));
        P p=new P(map);
        Integer userId = p.getInt("userId");
        String performance = p.getString("performance");
        String s = userService.selectUserById(userId);
        String[] split = s.split(",");
        Boolean aBoolean=false;
        Boolean temp=true;
        try {
            aBoolean=userService.updateSumTeamEnergySource(Arrays.asList(split), performance);
        }catch (Exception e){
            temp=false;
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }
        if(temp){
            if(aBoolean)
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            else
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }
    }


    @RabbitListener(queues = MqParamter.USER_QUEUE_NAME)
    public  void get1(Message message, Channel channel) throws Exception{

    }
}
