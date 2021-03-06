package com.yph.config;


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

//    @Bean
//    public DirectExchange defaultExchange() {
//        return new DirectExchange(MqParameterEnum.ShopBillQueue.getExchangeName());
//    }
//
//    @Bean
//    public Queue queue() {
//        //名字  是否持久化
//        return new Queue(MqParameterEnum.ShopBillQueue.getQueueName(), true);
//    }
//
//    @Bean
//    public Binding binding() {
//        //绑定一个队列  to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
//        return BindingBuilder.bind(queue()).to(defaultExchange()).with(MqParameterEnum.ShopBillQueue.getExchangeKeyName());
//    }

}