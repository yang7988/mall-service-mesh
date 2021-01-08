package com.example.mall.business.service;

import com.example.base.ApiResponse;
import com.example.base.HttpTemplate;
import com.example.mall.business.dto.BusinessDTO;
import com.example.mall.business.dto.CreateOrderDTO;
import com.example.mall.business.dto.DecStorageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService{

    @Override
    public ApiResponse handleBusiness(BusinessDTO businessDTO) {

        // 1扣减库存
        String storageUrl = "http://storage-service:30030/storage/dec_storage";

        HttpTemplate.postForJson(storageUrl, new DecStorageDTO.Builder()
                .commodityCode(businessDTO.getCommodityCode())
                .count(businessDTO.getCount()).build());

        // 2创建订单
        String orderUrl = "http://order-service:30020/order/create_order";

        return HttpTemplate.postForJson(orderUrl, new CreateOrderDTO.Builder()
                .commodityCode(businessDTO.getCommodityCode())
                .userId(businessDTO.getUserId())
                .orderCount(businessDTO.getCount()).orderAmount(businessDTO.getAmount()).build());
    }
}
