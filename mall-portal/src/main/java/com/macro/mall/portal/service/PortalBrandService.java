package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsProduct;

import java.util.List;

/**
 * Frontend brand management Service
 * Created by macro on 2020/5/15.
 */
public interface PortalBrandService {
    /**
     * Get recommended brands with pagination
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * Get brand details
     */
    PmsBrand detail(Long brandId);

    /**
     * Get brand-related products with pagination
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
