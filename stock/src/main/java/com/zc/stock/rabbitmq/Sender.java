package com.zc.stock.rabbitmq;

import com.zc.pay.pojo.OrderEntity;
import com.zc.stock.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 10:11
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param uuid
     * @param message  消息
     */
    public void send(String uuid,String message){
        Map<String,Object> map = new HashMap(16);
        map.put("msg",message);
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY1,
                map.toString(), correlationId);
    }

    public void send2(String uuid,String message){
        Map<String,Object> map = new HashMap(16);
        map.put("msg",message);
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY2,
                map.toString(), correlationId);
    }

}
