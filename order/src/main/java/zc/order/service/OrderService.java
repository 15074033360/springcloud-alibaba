package zc.order.service;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-08 10:00
 */
public interface OrderService {

    /**
     * 创建订单
     * @param userId
     * @param productId
     * @return
     */
    public String createOrder(Integer userId, Integer productId);
}
