package com.example.mall.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_storage")
public class Storage {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编码
     */
    @TableField(value = "commodity_code")
    private String commodityCode;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 商品库存
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;
}