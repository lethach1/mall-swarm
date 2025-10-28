package com.macro.mall.service;

import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product management Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductService {
    /**
     * Create product
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * Get update information by product ID
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * Update product
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * Query products with pagination
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * Batch update verification status
     * @param ids product IDs
     * @param verifyStatus verification status
     * @param detail verification details
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * Batch update product publish status
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * Batch update product recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Batch update new product status
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * Batch update delete status for products
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * Fuzzy query by product name or SKU
     */
    List<PmsProduct> list(String keyword);
}
