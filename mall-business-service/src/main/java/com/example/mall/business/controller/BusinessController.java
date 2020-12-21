package com.example.mall.business.controller;

import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.business.dto.BusinessDTO;
import com.example.mall.business.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
@Slf4j
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/getInfo")
    public ApiResponse<ApiBaseEnum> getInfo() {
        return ApiResponse.respond(ApiResponseEnum.SUCCESS,"this is business-service");
    }

    @PostMapping("/buy")
    ApiResponse handleBusiness(@RequestBody BusinessDTO businessDTO){
        log.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
