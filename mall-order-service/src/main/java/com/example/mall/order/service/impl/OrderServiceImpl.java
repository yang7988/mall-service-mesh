package com.example.mall.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.base.BizException;
import com.example.mall.dto.OrderDTO;
import com.example.mall.order.entity.Order;
import com.example.mall.order.mapper.OrderMapper;
import com.example.mall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public ApiResponse<Order> createOrder(OrderDTO orderDTO) {
        String url = "http://account-service:30010/account/dec_account";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        Map<String,Object> param = new HashMap<>();
        param.put("userId", orderDTO.getUserId());
        param.put("amount", orderDTO.getOrderAmount());

        HttpEntity<String> formEntity = new HttpEntity<>(JSON.toJSONString(param), headers);
        log.warn("调用账户中心服务扣减用户余额---url{}",url);
        ResponseEntity<ApiResponse> responseEntity = restTemplate.postForEntity(url, formEntity, ApiResponse.class);
        if(HttpStatus.OK != responseEntity.getStatusCode() ) {
            throw new BizException(ApiResponseEnum.FAIL, "扣减用户余额http调用失败");
        }
        ApiResponse entityBody = responseEntity.getBody();
        if(entityBody == null || entityBody.getCode() != ApiResponseEnum.SUCCESS.getCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "扣减用户余额失败");
        }

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

