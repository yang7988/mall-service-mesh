package com.example.mall.business.service;

import com.example.base.ApiResponse;
import com.example.mall.business.dto.BusinessDTO;

public interface BusinessService {

    /**
     * 出处理业务服务
     * @param businessDTO
     * @return
     */
    ApiResponse handleBusiness(BusinessDTO businessDTO);
}
