package com.macro.mall.dao;

import com.macro.mall.dto.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for flash promotion product relations
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionProductRelationDao {
    /**
     * Get flash promotion and related product information
     */
    List<SmsFlashPromotionProduct> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
