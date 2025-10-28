package com.macro.mall.dao;

import com.macro.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for product SKU management
 * Created by macro on 2018/4/26.
 */
public interface PmsSkuStockDao {
    /**
     * Batch insert operation
     */
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);

    /**
     * Batch insert or replace operation
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
