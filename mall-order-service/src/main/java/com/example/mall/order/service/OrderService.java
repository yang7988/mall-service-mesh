package com.example.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.base.ApiResponse;
import com.example.mall.dto.OrderDTO;
import com.example.mall.order.entity.Order;

public interface OrderService extends IService<Order> {

   ApiResponse<Order> createOrder(OrderDTO orderDTO);
}

