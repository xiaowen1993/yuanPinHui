package com.yph.modules.user.listener;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.Channel;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.IUserService;
import com.yph.paramter.MqParamter;
import com.yph.util.JSONUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用户等级升级队列
 */
@Component
public class LevelUpListener {

    @Autowired
    IUserService userService;

    @RabbitListener(queues = MqParamter.LEVEL_UP_QUEUE)
    public  void  get(Message message, Channel channel) throws Exception{
        // List<String>
        List<String> data = JSONUtils.toArray(new String(message.getBody()),String.class);
        QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("user_id",data);
        List<UserEntity> list = userService.list(queryWrapper);
        userService.userUpgrade(list);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}
