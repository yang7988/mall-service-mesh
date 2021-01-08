package com.example.mall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.base.ApiResponse;
import com.example.base.HttpTemplate;
import com.example.mall.order.dto.DecAccountDTO;
import com.example.mall.order.dto.OrderDTO;
import com.example.mall.order.entity.Order;
import com.example.mall.order.mapper.OrderMapper;
import com.example.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public ApiResponse<Order> createOrder(OrderDTO orderDTO) {
        String url = "http://account-service:30010/account/dec_account";
        HttpTemplate.postForJson(url, new DecAccountDTO.Builder().userId(orderDTO.getUserId()).amount(orderDTO.getOrderAmount()).build());
        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount());

        save(order);

        return ApiResponse.respond(order);
    }
}

