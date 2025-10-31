package com.macro.mall.portal.dao;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for home page content management
 * Created by macro on 2019/1/28.
 */
public interface HomeDao {

    /**
     * Get recommended brands
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * Get flash sale products
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * Get new product recommendations
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * Get popular product recommendations
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * Get recommended subjects
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
