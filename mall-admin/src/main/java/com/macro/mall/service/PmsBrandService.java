package com.macro.mall.service;

import com.macro.mall.dto.PmsBrandParam;
import com.macro.mall.model.PmsBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product brand Service
 * Created by macro on 2018/4/26.
 */
public interface PmsBrandService {
    /**
     * Get all brands
     */
    List<PmsBrand> listAllBrand();

    /**
     * Create brand
     */
    int createBrand(PmsBrandParam pmsBrandParam);

    /**
     * Update brand
     */
    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    /**
     * Delete brand
     */
    int deleteBrand(Long id);

    /**
     * Batch delete brands
     */
    int deleteBrand(List<Long> ids);

    /**
     * Paginated query of brands
     */
    List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * Get brand
     */
    PmsBrand getBrand(Long id);

    /**
     * Update display status
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * Update manufacturer status
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
