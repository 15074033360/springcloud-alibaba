package com.zc.stock.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 19:56
 */
public class RedisLock {


    @Autowired
    private RedissonClient redissonClient;





}
