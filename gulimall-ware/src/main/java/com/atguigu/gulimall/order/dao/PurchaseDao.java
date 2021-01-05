package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author chaikaixiang
 * @email chaikaixiang@163.com
 * @date 2021-01-05 10:07:29
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
