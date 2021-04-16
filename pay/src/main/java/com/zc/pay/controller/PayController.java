package com.zc.pay.controller;

import com.zc.common.utils.R;
import com.zc.pay.pojo.OrderEntity;
import com.zc.pay.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: zou
 * @desc:
 * @date:2021-04-08 15:02
 */
@RestController
@RequestMapping("pay")
@Slf4j
public class PayController {


    @Autowired
    private OrderService orderService;


    @RequestMapping("payTest")
    public String getString(){
        return "hello";
    }

    /**
     * 根据用户id查询订单信息
     * @param userId
     * @return
     */
    @RequestMapping("/findOrderByUserId/{userId}")
    public R findOrderByUserId(@PathVariable("userId") Integer userId) {
        log.info("根据userId:"+userId+"查询订单信息");
        List<OrderEntity> orderEntities = orderService.listByUserId(userId);
        return R.ok().put("orders", orderEntities);
    }


}
