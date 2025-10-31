package com.macro.mall.dao;

import com.macro.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for relations between product categories and attributes
 * Created by macro on 2018/5/23.
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * Batch create
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
