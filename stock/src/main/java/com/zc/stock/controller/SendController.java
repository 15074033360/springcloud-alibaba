package com.zc.stock.controller;

import com.zc.stock.rabbitmq.Sender;
import com.zc.stock.service.impl.StockServiceImpl;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StockServiceImpl stockService;

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
    public Map stockLow()throws Exception {
        Map maps = new HashMap(16);
        String lock="My_lock";
        RLock rLock= redissonClient.getLock(lock);
        rLock.lock(10, TimeUnit.SECONDS);
        rLock.tryLock(100,10,TimeUnit.SECONDS);
        rLock.lock();
        log.info("获取锁。。。。。");
        rLock.unlock();
        return maps ;
    }

    @RequestMapping("getByProductId")
    public int getByProductId(@RequestParam Integer id){
        return stockService.getByProduct(id);
    }

    @RequestMapping("decrease")
    public boolean decrease(@RequestParam Integer productId){
        return stockService.decrease(productId);
    }
}
