package com.zc.stock.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置  可以配置多个队列
 * @author zou
  *@date:2021/4/19-14:35
  *@CLassName:QueueConfig
   */
@Configuration
public class QueueConfig {

    @Bean
    public Queue firstQueue() {
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(RabbitMqConfig.QUEUE_NAME1,true,false,false);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(RabbitMqConfig.QUEUE_NAME2,true,false,false);}
    }