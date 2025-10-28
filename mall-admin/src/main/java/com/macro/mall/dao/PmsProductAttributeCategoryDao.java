package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * Custom DAO for product attribute categories
 * Created by macro on 2018/5/24.
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * Get product attribute categories that include attributes
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
