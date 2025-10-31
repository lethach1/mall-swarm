package com.macro.mall.portal.service;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * Home page content management Service
 * Created by macro on 2019/1/28.
 */
public interface HomeService {

    /**
     * Get home page content
     */
    HomeContentResult content();

    /**
     * Home page product recommendations
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * Get product categories
     * @param parentId 0: Get first-level categories; Otherwise: Get specified second-level categories
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * Get subjects by category with pagination
     * @param cateId Subject category ID
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**
     * Get popular recommended products with pagination
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * Get new product recommendations with pagination
     */
    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}
