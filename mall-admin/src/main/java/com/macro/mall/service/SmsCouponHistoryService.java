package com.macro.mall.service;

import com.macro.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * Coupon receive history management Service
 * Created by macro on 2018/11/6.
 */
public interface SmsCouponHistoryService {
    /**
     * Paginated query of coupon receive history
     * @param couponId Coupon ID
     * @param useStatus Use status
     * @param orderSn Order number
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
