package com.example.mall.business.dto;

public class DecStorageDTO {

    private String commodityCode;

    private Integer count;

    public DecStorageDTO(String commodityCode, Integer count) {
        this.commodityCode = commodityCode;
        this.count = count;
    }

    public DecStorageDTO() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCommodityCode() {
        return this.commodityCode;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static class Builder {
        private String commodityCode;
        private Integer count;

        public Builder() {
        }

        public DecStorageDTO.Builder commodityCode(String commodityCode) {
            this.commodityCode = commodityCode;
            return this;
        }

        public DecStorageDTO.Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public DecStorageDTO build() {
            return new DecStorageDTO(commodityCode, count);
        }

        public String toString() {
            return "DecStorageDTO.Builder(commodityCode=" + this.commodityCode + ", count=" + this.count + ")";
        }
    }
}
