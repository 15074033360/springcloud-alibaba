package com.zc.stock.controller;

import com.zc.stock.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 10:54
 */
@RestController
@RequestMapping("stock")
public class SendController {

    @Autowired
    Sender firstSender;

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
}
