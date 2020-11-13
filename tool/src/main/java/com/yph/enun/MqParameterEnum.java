package com.yph.enun;


import com.yph.paramter.MqParamter;

/**
 * Mq配置相关参数
 *
 * @author Agu
 */
public enum MqParameterEnum {

    //拼团队列
    UserQueue(MqParamter.USER_QUEUE_NAME, "direct.key", "userExchange");


    String queueName;

    String exchangeKeyName;

    String exchangeName;

    MqParameterEnum(String queueName, String exchangeKeyName, String exchangeName) {
        this.exchangeKeyName = exchangeKeyName;
        this.exchangeName = exchangeName;
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getExchangeKeyName() {
        return exchangeKeyName;
    }

    public String getExchangeName() {
        return exchangeName;
    }
}
