package com.macro.mall.dao;

import com.macro.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DAO for product parameters and custom specification attributes
 * Created by macro on 2018/4/26.
 */
public interface PmsProductAttributeValueDao {
    /**
     * Batch create
     */
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
