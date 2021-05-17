package zc.order.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
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
public class FirstConsumer implements ChannelAwareMessageListener {

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

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //1、获取消息的id
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {

            //2、获取消息
           log.info("message:"+new String(message.getBody()));

            //3、进行业务处理
            log.info("=====进行业务处理====");


            //模拟出现异常
            //int  i = 5/0;

            //4、进行消息签收
            channel.basicAck(deliveryTag, false);
            System.out.println("收到了消息:"+deliveryTag);
        } catch (Exception e) {

            //拒绝签收
             /*
            第三个参数：requeue：重回队列。如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
             */
             channel.basicNack(deliveryTag, false, true);

        }
    }
}