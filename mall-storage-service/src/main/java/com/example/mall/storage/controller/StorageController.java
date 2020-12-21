package com.example.mall.storage.controller;

import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.storage.dto.CommodityDTO;
import com.example.mall.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/getInfo")
    public ApiResponse<ApiBaseEnum> getInfo() {
        return ApiResponse.respond(ApiResponseEnum.SUCCESS,"this is storage-service");
    }

    @PostMapping("dec_storage")
    ApiResponse<ApiBaseEnum> decreaseStorage(@RequestBody CommodityDTO commodityDTO) {
        log.info("请求库存微服务：{}", commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}
