package zc.order.controller;

import com.zc.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zc.order.feign.PayFeignService;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-08 10:28
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    PayFeignService payFeignService;


    @RequestMapping("pay/{id}")
    public R pay(@PathVariable("id") Integer id){
        return payFeignService.findOrderByUserId(id);
    }


}
