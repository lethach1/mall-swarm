package com.macro.mall.portal.domain;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.SmsHomeAdvertise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Wrapper for home page content response
 * Created by macro on 2019/1/28.
 */
@Getter
@Setter
public class HomeContentResult {
    // Carousel advertisements
    private List<SmsHomeAdvertise> advertiseList;
    // Recommended brands
    private List<PmsBrand> brandList;
    // Current flash sale session
    private HomeFlashPromotion homeFlashPromotion;
    // New product recommendations
    private List<PmsProduct> newProductList;
    // Popular product recommendations
    private List<PmsProduct> hotProductList;
    // Recommended subjects
    private List<CmsSubject> subjectList;
}
