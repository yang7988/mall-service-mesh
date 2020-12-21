package com.example.mall.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.storage.dto.CommodityDTO;
import com.example.mall.storage.entity.Storage;
import com.example.mall.storage.mapper.StorageMapper;
import com.example.mall.storage.service.StorageService;
import org.springframework.stereotype.Service;
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService{


    @Override
    public ApiResponse<ApiBaseEnum> decreaseStorage(CommodityDTO commodityDTO) {
        int storage = baseMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ApiBaseEnum apiBaseEnum = storage >0 ? ApiResponseEnum.SUCCESS:ApiResponseEnum.FAIL;
        return ApiResponse.respond(apiBaseEnum);
    }
}
