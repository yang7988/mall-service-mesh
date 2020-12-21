package com.example.mall.account.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Valid
public class UpdateAccountDTO {

    @NotNull
    private Integer id;

    @NotBlank
    private String userId;

    @NotNull
    private BigDecimal amount;
}
