package com.example.mall.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.base.ApiBaseEnum;
import com.example.base.ApiResponse;
import com.example.mall.account.dto.AccountDTO;
import com.example.mall.account.dto.CreateAccountDTO;
import com.example.mall.account.dto.UpdateAccountDTO;
import com.example.mall.account.entity.Account;

public interface AccountService extends IService<Account> {

    ApiResponse<ApiBaseEnum> decreaseAccount(AccountDTO accountDTO);

    Account create(CreateAccountDTO account);

    Account updateAccount(UpdateAccountDTO dto);
}

