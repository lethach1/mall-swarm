package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * Custom DAO for product categories
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    /**
     * Get product categories and their subcategories
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
