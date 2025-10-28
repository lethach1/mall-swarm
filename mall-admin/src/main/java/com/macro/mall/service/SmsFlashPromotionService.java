package com.macro.mall.service;

import com.macro.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * Flash promotion activity management Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionService {
    /**
     * Add activity
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * Update specified activity
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * Delete single activity
     */
    int delete(Long id);

    /**
     * Update online/offline status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Get detailed information
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * Paginated query of activities
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);
}
