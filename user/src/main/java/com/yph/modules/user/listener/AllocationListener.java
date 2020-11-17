package com.yph.modules.user.listener;

import com.rabbitmq.client.Channel;
import com.yph.entity.AllocationDto;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.AllocationService;
import com.yph.paramter.MqParamter;
import com.yph.util.JSONUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 *伞下
 * @author Agu
 */
@Component
public class AllocationListener {


    @Autowired
    AllocationService allocationService;


    @RabbitListener(queues = MqParamter.ALLOCATION_QUEUE_NAME)
    public  void  get(Message message , Channel channel) throws Exception{
        AllocationDto userEntity = JSONUtils.toObject(new String(message.getBody()), AllocationDto.class);


        allocationService.allocation(userEntity);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}
