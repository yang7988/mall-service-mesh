package com.example.mall.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.account.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 减少账户余额
     * @param userId
     * @param amount
     * @return
     */
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}