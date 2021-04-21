package zc.order.service.impl;

import com.zc.common.pojo.OrderEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zc.order.feign.StockFeignService;
import zc.order.service.OrderService;

import java.util.concurrent.TimeUnit;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-21 10:18
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger log=LogManager.getLogger(this.getClass());

    @Autowired
    private StockFeignService stockFeignService;

    @Autowired
    private RedissonClient redissonClient;



    @Override
    public String createOrder(Integer userId, Integer productId) {

        int stock = stockFeignService.getByProductId(productId);
        log.info("剩余库存：{}",stock);
        if (stock<=0){
            return null;
        }
        RLock lock = redissonClient.getLock("stock:" + productId);
        try {
            lock.lock(10, TimeUnit.SECONDS);
            log.info("获取锁");
            if (stockFeignService.decrease(productId)){
                log.info("生成订单");
                OrderEntity orderEntity= new OrderEntity();
                orderEntity.setAmount(productId);
                orderEntity.setCommodityCode("");
                orderEntity.setCount(userId);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }



        return null;
    }
}
