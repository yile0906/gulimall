package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author chaikaixiang
 * @email chaikaixiang@163.com
 * @date 2021-01-05 10:06:21
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
