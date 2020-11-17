package com.yph.config;


import com.yph.enun.MqParameterEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MqConfig {


//    @Bean
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
//        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
//        simpleRabbitListenerContainerFactory.setBatchListener(true);
//        simpleRabbitListenerContainerFactory.setConsumerBatchEnabled(true);
////        simpleRabbitListenerContainerFactory.setBatchSize(100);
//        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return simpleRabbitListenerContainerFactory;
//    }

    @Bean
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        //注意  这个ConnectionFactory 是使用javaconfig方式配置连接的时候才需要传入的  如果是yml配置的连接的话是不需要的
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(MqParameterEnum.UserQueue.getExchangeName());
    }

    @Bean
    public Queue queue() {
        //名字  是否持久化
        return new Queue(MqParameterEnum.UserQueue.getQueueName(), true);
    }

    @Bean
    public Binding binding() {
        //绑定一个队列  to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(MqParameterEnum.UserQueue.getExchangeKeyName());
    }



    @Bean
    public DirectExchange allocationExchange() {
        return new DirectExchange(MqParameterEnum.AllocationQueue.getExchangeName());
    }

    @Bean
    public Queue allocationQueue() {
        //名字  是否持久化
        return new Queue(MqParameterEnum.AllocationQueue.getQueueName(), true);
    }

    @Bean
    public Binding allocationBinding() {
        //绑定一个队列  to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(MqParameterEnum.AllocationQueue.getExchangeKeyName());
    }

}