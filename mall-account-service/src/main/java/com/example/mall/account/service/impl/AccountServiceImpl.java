package com.example.mall.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.base.ApiResponseEnum;
import com.example.mall.account.dto.AccountDTO;
import com.example.mall.account.dto.CreateAccountDTO;
import com.example.mall.account.dto.UpdateAccountDTO;
import com.example.mall.account.entity.Account;
import com.example.mall.account.mapper.AccountMapper;
import com.example.mall.account.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService{

    @Override
    public Account create(CreateAccountDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto,account);
        save(account);
        return account;
    }

    @Override
    public ApiResponse<ApiBaseEnum> decreaseAccount(AccountDTO accountDTO) {
        int account = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ApiBaseEnum apiBaseEnum = account > 0?ApiResponseEnum.SUCCESS:ApiResponseEnum.FAIL;
        return ApiResponse.respond(apiBaseEnum);
    }

    @Override
    public Account updateAccount(UpdateAccountDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto,account);
        updateById(account);
        return getById(dto.getId());
    }
}
