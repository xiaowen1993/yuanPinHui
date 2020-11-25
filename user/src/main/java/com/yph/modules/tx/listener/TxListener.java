package com.yph.modules.tx.listener;

import com.rabbitmq.client.Channel;
import com.yph.entity.ScriptEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TxListener {


    @Autowired
    IRespBlockService respBlockService;

    @Autowired
    IRespTxService respTxService;

    @RabbitListener(queues = MqParamter.TX_QUEUE_NAME)
    public  void listener(Message message, Channel channel) throws Exception{
        Map<String,Object> map = JSONUtils.toMap(new String(message.getBody()));
        P p=new P(map);
        RespBlockEntity respBlockEntity = get(p);
        List<Map<String,Object>> txs = ((List<Map<String, Object>>) p.get("Txs"));
        List<RespTxEntity> tx = getTx(txs,respBlockEntity.getHeight());
        if (tx.size()>0){
            respBlockService.save(respBlockEntity);
            respTxService.saveBatch(tx);
        }
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }



    public List<RespTxEntity> getTx(List<Map<String,Object>>  list,Long number){
        List<RespTxEntity> returnList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            RespTxEntity respTxEntity = new RespTxEntity();
            P p = new P(map);
            respTxEntity.setScript(p.getString("Script"));
            ScriptEntity scriptEntity = getScriptEntity(respTxEntity.getScript());
            if (scriptEntity==null||!scriptEntity.getName().equals("BPC")) {
                continue;
            }
            respTxEntity.setAmount(p.getBigDecimal("Amount"));
            respTxEntity.setFrom(p.getString("From"));
            respTxEntity.setHash(p.getString("Hash"));
            respTxEntity.setNonce(p.getString("Nonce"));
            respTxEntity.setRespBlockId(number);
            respTxEntity.setTo(p.getString("To"));
            respTxEntity.setSignature(p.getString("Signature"));
            respTxEntity.setTime(p.getDate("Time"));
            returnList.add(respTxEntity);
        }
        return returnList;
    }


    public ScriptEntity getScriptEntity(String script){
        return ScriptEntity.getScriptEntity(script);
    }

    public RespBlockEntity get(P p){
        RespBlockEntity respBlockEntity=new RespBlockEntity();
        respBlockEntity.setHeight(p.getLong("Height"));
        respBlockEntity.setHash(p.getString("Hash"));
        respBlockEntity.setMiner(p.getString("Miner"));
        respBlockEntity.setPrevblockHash(p.getString("PrevBlockHash"));
        respBlockEntity.setRoot(p.getString("Root"));
        respBlockEntity.setTimestamp(p.getDate("Timestamp"));
        respBlockEntity.setVersion(p.getString("Version"));
        return respBlockEntity;
    }
}
