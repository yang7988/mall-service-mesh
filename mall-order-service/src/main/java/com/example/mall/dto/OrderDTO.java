package com.example.mall.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 2064686513919089666L;

    private String orderNo;

    private String userId;

    private String commodityCode;

    private Integer orderCount;

    private BigDecimal orderAmount;

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDTO.class.getSimpleName() + "[", "]")
                .add("orderNo='" + orderNo + "'")
                .add("userId='" + userId + "'")
                .add("commodityCode='" + commodityCode + "'")
                .add("orderCount=" + orderCount)
                .add("orderAmount=" + orderAmount)
                .toString();
    }
}


