package zc.order.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;


/**
 *@author: zou
 *@desc:
 *@date:2021/4/19-11:16
 *@CLassName:FirstConsumer
  */
@Component
@Slf4j
public class FirstConsumer {

    /**
     * queues  指定从哪个队列（queue）订阅消息
     *
     * @param message
     */
    @RabbitListener(queues = {"first-queue"})
    public void handleMessage(Message message) {
        // 处理消息
        log.info("first msg :{}", JSON.toJSONString(new String(message.getBody())));
        log.info("接收到的消息"+new String(message.getBody()));
    }

}