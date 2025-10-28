package com.macro.mall.service;

import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product category Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductCategoryService {
    /**
     * Create product category
     */
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Update product category
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Get product categories with pagination
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * Delete product category
     */
    int delete(Long id);

    /**
     * Get product category by ID
     */
    PmsProductCategory getItem(Long id);

    /**
     * Batch update navigation status
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * Batch update display status
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * Get product categories in hierarchical form
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
