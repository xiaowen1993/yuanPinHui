package com.runner;

import com.grpc.GrpcParameter;
import com.grpc.GrpcUtil;
import com.grpc.enun.NumberThresholdValue;
import com.yph.enun.MqParameterEnum;
import com.yph.util.JSONUtils;
import com.yph.util.MqUtil;
import message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Agu
 */
@Component
public class SpringBootStartedRunner implements ApplicationRunner {


    @Autowired
    MqUtil mqUtil;


    @Autowired
    GrpcUtil grpcUtil;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    //一次处理一个区块，每秒钟会生成新的区块， 每个区块必须处理到， 不能重复处理
    //
    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {

            //获取当前的最大区块号
            long maxBlockNumber = grpcUtil.getMaxBlockNumber();
            //拿来与redis的区块号做比较
            long redisNumber = getRedisNumber();
            //可以提供一定差值作为缓冲。。。
            long interval = maxBlockNumber - redisNumber;
            if (interval <= GrpcParameter.buffer) {
                Thread.sleep(getTime(interval));
                continue;
            }
            //当前区块的所有交易 应该吧此区块入库，并且把里面每笔与系统相关交易入库
            Message.resp_block blockByNum = grpcUtil.getBlockByNum(redisNumber);
            if (blockByNum.getTxsList().size() > 0) {
                Map<String, Object> map = objToMap(blockByNum);
                mqUtil.testSend(MqParameterEnum.TxQueue.getExchangeName(), MqParameterEnum.TxQueue.getExchangeKeyName(), map);
            }
            //版本当版本差距大小不同时，处理速度应不相同
            //版本差距大处理速度快，版本差距小，应放慢速度
            long time = getTime(interval);
            addNumber();
            Thread.sleep(time);
        }
    }

    public Map<String, Object> objToMap(Message.resp_block msg) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, Object>> txList = new ArrayList<>();
        //区块高度
        returnMap.put("Height", msg.getHeight());
        //上一个区块值
        returnMap.put("PrevBlockHash", msg.getPrevBlockHash());
        //根
        returnMap.put("Root", msg.getRoot());
        //版本号
        returnMap.put("Version", msg.getVersion());
        //该区块时间戳
        returnMap.put("Timestamp", msg.getTimestamp());
        //区块哈希
        returnMap.put("Hash", msg.getHash());
        //矿工地址
        returnMap.put("Miner", msg.getMiner());
        for (Message.Tx tx : msg.getTxsList()) {
            Map<String,Object> txMap = new HashMap<>();
            txMap.put("Nonce",tx.getNonce());
            //kto金额
            txMap.put("Amount",tx.getAmount());
            //交易发起者
            txMap.put("From",tx.getFrom());
            //交易收益者
            txMap.put("To",tx.getTo());
            //交易哈希码
            txMap.put("Hash",tx.getHash());
            //交易签名
            txMap.put("Signature",tx.getSignature());
            //时间戳 S
            txMap.put("Time",tx.getTime());
            //脚本
            txMap.put("Script",tx.getScript());
            txList.add(txMap);
        }
        returnMap.put("Txs", txList);
        return returnMap;
    }

    public long getTime(long time) {
        return NumberThresholdValue.getTimeMs(time);
    }

    public RedisAtomicLong getRedisAtomicLong() {
        return new RedisAtomicLong("nowMaxNumber", redisConnectionFactory);
    }

    public long getRedisNumber() {
        RedisAtomicLong redisAtomicLong = getRedisAtomicLong();
        long l = redisAtomicLong.get();
        if (l == 0) {
            return redisAtomicLong.addAndGet(26683310);
        }
        return l;
    }


    public long addNumber() {
        return getRedisAtomicLong().incrementAndGet();
    }
}

