package zc.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-15 17:35
 */
@FeignClient(value = "pay-zc",path = "/pay")
public interface PayFeignService {

    @RequestMapping("/findOrderByUserId/{userId}")
    public int findOrderByUserId(@PathVariable("userId") Integer userId);
}
