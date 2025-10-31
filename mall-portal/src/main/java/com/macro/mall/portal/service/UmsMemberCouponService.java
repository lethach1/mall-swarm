package com.macro.mall.portal.service;

import com.macro.mall.model.SmsCoupon;
import com.macro.mall.model.SmsCouponHistory;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Member coupon management Service
 * Created by macro on 2018/8/29.
 */
public interface UmsMemberCouponService {
    /**
     * Member adds coupon
     */
    @Transactional
    void add(Long couponId);

    /**
     * Get coupon history list
     */
    List<SmsCouponHistory> listHistory(Integer useStatus);

    /**
     * Get available coupons based on cart information
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);

    /**
     * Get coupons related to current product
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * Get member coupon list
     */
    List<SmsCoupon> list(Integer useStatus);
}
