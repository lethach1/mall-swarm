package com.macro.mall.service;

import com.macro.mall.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home page popular recommendations management Service
 * Created by macro on 2018/11/7.
 */
public interface SmsHomeRecommendProductService {
    /**
     * Add home page recommendations
     */
    @Transactional
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    /**
     * Update recommendation sort order
     */
    int updateSort(Long id, Integer sort);

    /**
     * Batch delete recommendations
     */
    int delete(List<Long> ids);

    /**
     * Update recommendation status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paginated query of recommendations
     */
    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
