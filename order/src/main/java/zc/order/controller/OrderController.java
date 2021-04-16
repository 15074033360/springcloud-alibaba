package zc.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-08 10:28
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping("test")
    public String getString(){
        return "hello";
    }
}
