package com.macro.mall.dao;

import com.macro.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for relations between coupons and product categories
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponProductCategoryRelationDao {
    /**
     * Batch create
     */
    int insertList(@Param("list")List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
