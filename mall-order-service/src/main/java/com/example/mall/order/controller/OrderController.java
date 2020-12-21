package com.example.mall.order.controller;

import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.dto.OrderDTO;
import com.example.mall.order.entity.Order;
import com.example.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getInfo")
    public ApiResponse<ApiBaseEnum> getInfo() {
        return ApiResponse.respond(ApiResponseEnum.SUCCESS,"this is order-service");
    }

    @PostMapping("/create_order")
    ApiResponse<Order> createOrder(@RequestBody OrderDTO orderDTO){
        log.info("请求订单微服务：{}",orderDTO.toString());
        return orderService.createOrder(orderDTO);
    }
}
