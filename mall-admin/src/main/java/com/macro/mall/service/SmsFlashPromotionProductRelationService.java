package com.macro.mall.service;

import com.macro.mall.dto.SmsFlashPromotionProduct;
import com.macro.mall.model.SmsFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Flash promotion product relation management Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionProductRelationService {
    /**
     * Batch add relations
     */
    @Transactional
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * Update relation information
     */
    int update(Long id, SmsFlashPromotionProductRelation relation);

    /**
     * Delete relation
     */
    int delete(Long id);

    /**
     * Get relation details
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * Paginated query of related products and promotion info
     *
     * @param flashPromotionId        Flash promotion ID
     * @param flashPromotionSessionId Flash promotion session ID
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * Get relation count by promotion and session IDs
     * @param flashPromotionId Flash promotion ID
     * @param flashPromotionSessionId Flash promotion session ID
     * @return count
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
}
