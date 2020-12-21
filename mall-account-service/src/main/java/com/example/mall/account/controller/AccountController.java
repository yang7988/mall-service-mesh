package com.example.mall.account.controller;

import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.account.dto.AccountDTO;
import com.example.mall.account.dto.CreateAccountDTO;
import com.example.mall.account.dto.UpdateAccountDTO;
import com.example.mall.account.entity.Account;
import com.example.mall.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
@Slf4j
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getInfo")
    public ApiResponse<ApiBaseEnum> getInfo() {
        return ApiResponse.respond(ApiResponseEnum.SUCCESS,"this is account-service");
    }

    @PostMapping("/create")
    ApiResponse<Account> create(@RequestBody CreateAccountDTO dto) {
        return ApiResponse.respond(accountService.create(dto));
    }

    @GetMapping("/get/{id}")
    ApiResponse<Account> get(@PathVariable("id") Integer id) {
        return ApiResponse.respond(accountService.getById(id));
    }

    @DeleteMapping("/delete/{userId}")
    ApiResponse<ApiBaseEnum> delete(@PathVariable("userId") String userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("user_id", userId);
        accountService.removeByMap(map);
        return ApiResponse.respond();
    }

    @PostMapping("/update")
    ApiResponse<Account> update(@RequestBody UpdateAccountDTO dto) {
        return ApiResponse.respond(accountService.updateAccount(dto));
    }

    @PostMapping("/dec_account")
    ApiResponse<ApiBaseEnum> decreaseAccount(@RequestBody AccountDTO accountDTO) {
        log.info("请求账户微服务：{}", accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }
}
