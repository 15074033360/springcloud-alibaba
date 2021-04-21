package zc.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-21 15:04
 */
@FeignClient(value = "stock-zc",path = "/stock")
public interface StockFeignService {


    /**
     * 查库存
     * @param id
     * @return
     */
    @RequestMapping("getByProductId")
    public int getByProductId(@RequestParam Integer id);

    /**
     * 扣库存
     * @param productId
     * @return
     */
    @RequestMapping("decrease")
    public boolean decrease(@RequestParam Integer productId);


}
