package com.example.mall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

@Data
@TableName(value = "t_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 商品编码
     */
    @TableField(value = "commodity_code")
    private String commodityCode;

    /**
     * 商品数量
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 订单金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;
}