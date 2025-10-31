package com.macro.mall.service;

import com.macro.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home page brand management Service
 * Created by macro on 2018/11/6.
 */
public interface SmsHomeBrandService {
    /**
     * Create home page brand recommendations
     */
    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * Update brand recommendation sort order
     */
    int updateSort(Long id, Integer sort);

    /**
     * Batch delete brand recommendations
     */
    int delete(List<Long> ids);

    /**
     * Update recommend status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paginated query of brand recommendations
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
