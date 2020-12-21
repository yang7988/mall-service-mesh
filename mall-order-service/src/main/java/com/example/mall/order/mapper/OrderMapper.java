package com.example.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.order.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {

    void createOrder(@Param("order") Order order);
}