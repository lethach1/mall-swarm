package com.macro.mall.service;

import com.macro.mall.dto.SmsFlashPromotionSessionDetail;
import com.macro.mall.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * Flash promotion session management Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionSessionService {
    /**
     * Create session
     */
    int create(SmsFlashPromotionSession promotionSession);

    /**
     * Update session
     */
    int update(Long id, SmsFlashPromotionSession promotionSession);

    /**
     * Update session enable status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Delete session
     */
    int delete(Long id);

    /**
     * Get detail
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * Get session list by enable status
     */
    List<SmsFlashPromotionSession> list();

    /**
     * Get all selectable sessions and their counts
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
