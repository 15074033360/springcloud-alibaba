package zc.order.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 11:16
 */
@Component
@Slf4j
public class SecondConsumer {



    @RabbitListener(queues = {"first-queue","second-queue"})
    public void handleMessage(Message message) throws Exception {
        // 处理消息
        log.info("second msg :{}", JSON.toJSONString(new String(message.getBody())));
        System.out.println("SecondConsumer {} handleMessage :"+message);
    }
}
