package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author chaikaixiang
 * @email chaikaixiang@163.com
 * @date 2021-01-05 10:07:29
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
