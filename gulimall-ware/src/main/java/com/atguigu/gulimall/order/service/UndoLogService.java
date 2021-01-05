package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author chaikaixiang
 * @email chaikaixiang@163.com
 * @date 2021-01-05 10:07:29
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

