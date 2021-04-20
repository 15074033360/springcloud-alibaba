package com.zc.stock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *@author: zou
 *@desc:
 *@date:2021/4/8-10:03
 *@CLassName:StockApplication
  */
@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }


   /* @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().
                setAddress("localhost:6379").
                setPassword("");
        //设置编码
        config.setCodec(new StringCodec());
        return Redisson.create(config);
    }*/
}
