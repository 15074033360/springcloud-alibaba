package com.zc.stock.mqcallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 10:27
 */
@Slf4j
public class MsgSendReturnCallBack  implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.info("消息："+message+","+i+","+s+","+s1+","+s2);
    }
}
