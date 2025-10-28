package com.macro.mall.service;

import com.macro.mall.dto.PmsProductAttributeParam;
import com.macro.mall.dto.ProductAttrInfo;
import com.macro.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product attribute Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductAttributeService {
    /**
     * Get product attributes by category with pagination
     * @param cid category ID
     * @param type 0->attribute; 2->parameter
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * Add product attribute
     */
    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    /**
     * Update product attribute
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * Get single product attribute information
     */
    PmsProductAttribute getItem(Long id);

    @Transactional
    int delete(List<Long> ids);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
