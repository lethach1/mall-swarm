package com.macro.mall.service;

import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Coupon management Service
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponService {
    /**
     * Add coupon
     */
    @Transactional
    int create(SmsCouponParam couponParam);

    /**
     * Delete coupon by ID
     */
    @Transactional
    int delete(Long id);

    /**
     * Update coupon by ID
     */
    @Transactional
    int update(Long id, SmsCouponParam couponParam);

    /**
     * Get coupon list with pagination
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * Get coupon details
     * @param id coupon table ID
     */
    SmsCouponParam getItem(Long id);
}
