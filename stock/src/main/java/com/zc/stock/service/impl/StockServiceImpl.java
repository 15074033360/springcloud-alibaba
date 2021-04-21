package com.zc.stock.service.impl;

import com.zc.stock.service.StockService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-21 10:32
 */
@Component
public class StockServiceImpl implements StockService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int getByProduct(Integer productId) {
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String value = hashOperations.get("stock", String.valueOf(productId));
        if (StringUtils.isBlank(value)) {
                        return 0;
        }
        return Integer.valueOf(value);
    }

    @Override
    public boolean decrease(Integer productId) {
        int stock=getByProduct(productId);
        if (stock<=0){
            return false;
        }
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put("stock", String.valueOf(productId), String.valueOf(stock - 1));
         return true;
    }
}
