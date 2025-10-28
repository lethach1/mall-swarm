package com.macro.mall.service;

import com.macro.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * Coupon receiving record management Service
 * Created by macro on 2018/11/6.
 */
public interface SmsCouponHistoryService {
    /**
     * Paginated query of coupon receiving records
     * @param couponId coupon ID
     * @param useStatus use status
     * @param orderSn order number
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
