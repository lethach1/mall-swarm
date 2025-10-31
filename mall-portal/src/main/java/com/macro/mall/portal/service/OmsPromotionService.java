package com.macro.mall.portal.service;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * Created by macro on 2018/8/27.
 * Promotion management Service
 */
public interface OmsPromotionService {
    /**
     * Calculate promotion information for cart items
     * @param cartItemList Shopping cart items
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
