package com.zc.stock.controller;

import com.zc.stock.rabbitmq.Sender;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 10:54
 */
@RestController
@RequestMapping("stock")
public class SendController {
    private   final Logger log= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Sender firstSender;
   /* @Resource
    private  RedissonClient redissonClient;*/

    @GetMapping("/send")
    public String send(String message){
        String uuid = UUID.randomUUID().toString();
        firstSender.send(uuid,message);
        return uuid;
}

    @GetMapping("/send2")
    public String send2(String message){
        String uuid = UUID.randomUUID().toString();
        firstSender.send2(uuid,message);
        return uuid;
    }

    /**
     * 订单提交成功，扣减库存
     * @param
     * @return
     */
    @RequestMapping("stock")
    public Map stockLow() {
        Map maps = new HashMap(16);
        String lock="My_lock";
//        RLock rLock= redissonClient.getLock(lock);
//        rLock.lock();
//        log.info("获取锁。。。。。");
//        rLock.unlock();
        return maps ;
    }
}
