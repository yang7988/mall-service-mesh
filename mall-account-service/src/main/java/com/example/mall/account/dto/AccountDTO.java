package com.example.mall.account.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 4481954070057875313L;
    private Integer id;

    private String userId;

    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccountDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId='" + userId + "'")
                .add("amount=" + amount)
                .toString();
    }
}
