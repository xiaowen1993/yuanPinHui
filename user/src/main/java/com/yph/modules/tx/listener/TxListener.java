package com.yph.modules.tx.listener;

import com.rabbitmq.client.Channel;
import com.yph.modules.tx.entity.RespBlockEntity;
import com.yph.modules.tx.entity.RespTxEntity;
import com.yph.modules.tx.service.IRespBlockService;
import com.yph.modules.tx.service.IRespTxService;
import com.yph.paramter.MqParamter;
import com.yph.util.JSONUtils;
import com.yph.util.P;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class TxListener {


    @Autowired
    IRespBlockService respBlockService;

    @Autowired
    IRespTxService respTxService;

    @RabbitListener(queues = MqParamter.TX_QUEUE_NAME)
    @Transactional
    public  void listener(Message message, Channel channel) throws Exception{
        Map<String,Object> map = JSONUtils.toMap(new String(message.getBody()));
        P p=new P(map);
        RespBlockEntity respBlockEntity = get(p);
        List<RespTxEntity> txs = JSONUtils.toArray(p.getString("Txs"), RespTxEntity.class);
        respBlockService.save(respBlockEntity);
        respTxService.saveBatch(txs);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }



    public RespBlockEntity get(P p){
        RespBlockEntity respBlockEntity=new RespBlockEntity();
        respBlockEntity.setHeight(p.getString("Height"));
        respBlockEntity.setHash(p.getString("Hash"));
        respBlockEntity.setMiner(p.getString("Miner"));
        respBlockEntity.setPrevblockHash(p.getString("PrevBlockHash"));
        respBlockEntity.setRoot(p.getString("Root"));
        respBlockEntity.setTimestamp(p.getDate("Timestamp"));
        respBlockEntity.setVersion(p.getString("Version"));
        return respBlockEntity;
    }
}
