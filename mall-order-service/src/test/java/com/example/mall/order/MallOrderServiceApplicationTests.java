package com.example.mall.order;

import com.example.mall.order.dto.OrderDTO;
import com.example.mall.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class MallOrderServiceApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateOrder() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId("d3d9daf0147642bf8c3e38641c381068");
        orderDTO.setCommodityCode("123kjhi");
        orderDTO.setOrderCount(2);
        orderDTO.setOrderAmount(BigDecimal.valueOf(10000.00));
        orderService.createOrder(orderDTO);
    }

}
