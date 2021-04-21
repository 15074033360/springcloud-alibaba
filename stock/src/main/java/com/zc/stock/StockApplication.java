package com.zc.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author: zou
 *@desc:
 *@date:2021/4/8-10:03
 *@CLassName:StockApplication
  */
@SpringBootApplication
@EnableFeignClients
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
