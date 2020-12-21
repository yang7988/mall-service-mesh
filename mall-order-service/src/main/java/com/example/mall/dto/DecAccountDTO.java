package com.example.mall.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DecAccountDTO {

    private String userId;

    private BigDecimal amount;
}
