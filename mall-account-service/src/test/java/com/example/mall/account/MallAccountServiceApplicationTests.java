package com.example.mall.account;

import com.example.mall.account.entity.Account;
import com.example.mall.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
class MallAccountServiceApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAccount() {
        Account account = new Account();
        account.setUserId(UUID.randomUUID().toString().replace("-",""));
        account.setAmount(new BigDecimal("100"));
        account.setVersion(0);
        accountService.save(account);

    }

}
