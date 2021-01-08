package com.example.mall.order.dto;

import java.math.BigDecimal;

public class DecAccountDTO {

    private String userId;

    private BigDecimal amount;

    public DecAccountDTO(String userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public DecAccountDTO() {
    }

    private static Builder builder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static class Builder {
        private String userId;
        private BigDecimal amount;

        public Builder() {
        }

        public DecAccountDTO.Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public DecAccountDTO.Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public DecAccountDTO build() {
            return new DecAccountDTO(userId, amount);
        }

        public String toString() {
            return "DecAccountDTO.Builder(userId=" + this.userId + ", amount=" + this.amount + ")";
        }
    }
}
