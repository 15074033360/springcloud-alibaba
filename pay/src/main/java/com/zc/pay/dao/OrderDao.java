package com.zc.pay.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zc.pay.pojo.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author fox
 * @email 2763800211@qq.com
 * @date 2021-01-28 15:46:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
