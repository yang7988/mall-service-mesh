package com.example.mall.account.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Valid
public class CreateAccountDTO {

    /**
     * 用户id
     */
    @NotBlank
    private String userId;

    /**
     * 账户余额
     */
    @NotNull
    private BigDecimal amount;
}
