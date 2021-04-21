package com.zc.stock.service;

/**
 * @author: zou
 * @desc:
 * @date:2021-04-21 10:23
 */
public interface StockService {


    /**
     * 根据Id 查询该商品库存数量
     * @param productId
     * @return
     */
    public int getByProduct(Integer productId) ;


    /**
     * 扣减库存
     * @param productId
     * @return
     */
    public boolean decrease(Integer productId);
}
