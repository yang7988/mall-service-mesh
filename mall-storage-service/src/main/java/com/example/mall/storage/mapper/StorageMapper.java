package com.example.mall.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.storage.entity.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper extends BaseMapper<Storage> {

    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}