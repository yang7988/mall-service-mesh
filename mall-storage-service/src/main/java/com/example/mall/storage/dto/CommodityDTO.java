package com.example.mall.storage.dto;

import java.io.Serializable;
import java.util.StringJoiner;

public class CommodityDTO implements Serializable {
    private static final long serialVersionUID = -1931259808569208575L;
    private Integer id;

    private String commodityCode;

    private String name;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CommodityDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("commodityCode='" + commodityCode + "'")
                .add("name='" + name + "'")
                .add("count=" + count)
                .toString();
    }
}
