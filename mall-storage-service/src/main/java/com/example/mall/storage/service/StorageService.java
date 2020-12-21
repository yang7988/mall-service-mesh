package com.example.mall.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.mall.storage.dto.CommodityDTO;
import com.example.mall.storage.entity.Storage;
public interface StorageService extends IService<Storage>{

   ApiResponse<ApiBaseEnum> decreaseStorage(CommodityDTO commodityDTO);
}
