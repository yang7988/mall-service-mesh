package com.example.mall.business.service;

import com.alibaba.fastjson.JSON;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.base.BizException;
import com.example.mall.business.dto.BusinessDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResponse handleBusiness(BusinessDTO businessDTO) {

        // 1扣减库存
        String storageUrl = "http://storage-service:30030/storage/dec_storage";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        Map<String,Object> param = new HashMap<>();
        param.put("commodityCode", businessDTO.getCommodityCode());
        param.put("count", businessDTO.getCount());
        HttpEntity<String> formEntity = new HttpEntity<>(JSON.toJSONString(param), headers);

        log.warn("调用库存中心服务扣减商品库存---url:{}",storageUrl);
        ResponseEntity<ApiResponse> storageEntity = restTemplate.postForEntity(storageUrl, formEntity, ApiResponse.class);

        if(HttpStatus.OK !=storageEntity.getStatusCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "扣减库存服务http调用失败");
        }
        if(storageEntity.getBody() == null || storageEntity.getBody().getCode() != ApiResponseEnum.SUCCESS.getCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "扣减库存服务调用失败");
        }

        // 2创建订单
        String orderUrl = "http://order-service:30020/order/create_order";
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        httpHeaders.setContentType(mediaType);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());

        Map<String,Object> map = new HashMap<>();
        map.put("commodityCode", businessDTO.getCommodityCode());
        map.put("userId", businessDTO.getUserId());
        map.put("orderCount", businessDTO.getCount());
        map.put("orderAmount", businessDTO.getAmount());

        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(map), httpHeaders);

        log.warn("调用订单中心服务创建订单---url:{}",orderUrl);
        ResponseEntity<ApiResponse> orderEntity = restTemplate.postForEntity(orderUrl, httpEntity, ApiResponse.class);

        if(HttpStatus.OK !=orderEntity.getStatusCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "创建订单服务http调用失败");
        }
        if(orderEntity.getBody() == null || orderEntity.getBody().getCode() != ApiResponseEnum.SUCCESS.getCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "创建订单服务调用失败");
        }
        return orderEntity.getBody();
    }
}
