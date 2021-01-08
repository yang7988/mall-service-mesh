package com.example.mall.business.dto;

import java.math.BigDecimal;

public class CreateOrderDTO {

    private String commodityCode;

    private String userId;

    private Integer orderCount;

    private BigDecimal orderAmount;

    public CreateOrderDTO(String commodityCode, String userId, Integer orderCount, BigDecimal orderAmount) {
        this.commodityCode = commodityCode;
        this.userId = userId;
        this.orderCount = orderCount;
        this.orderAmount = orderAmount;
    }

    public CreateOrderDTO() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCommodityCode() {
        return this.commodityCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public Integer getOrderCount() {
        return this.orderCount;
    }

    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public static class Builder {
        private String commodityCode;
        private String userId;
        private Integer orderCount;
        private BigDecimal orderAmount;

        public Builder() {
        }

        public CreateOrderDTO.Builder commodityCode(String commodityCode) {
            this.commodityCode = commodityCode;
            return this;
        }

        public CreateOrderDTO.Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public CreateOrderDTO.Builder orderCount(Integer orderCount) {
            this.orderCount = orderCount;
            return this;
        }

        public CreateOrderDTO.Builder orderAmount(BigDecimal orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public CreateOrderDTO build() {
            return new CreateOrderDTO(commodityCode, userId, orderCount, orderAmount);
        }

        public String toString() {
            return "CreateOrderDTO.Builder(commodityCode=" + this.commodityCode + ", userId=" + this.userId + ", orderCount=" + this.orderCount + ", orderAmount=" + this.orderAmount + ")";
        }
    }
}
