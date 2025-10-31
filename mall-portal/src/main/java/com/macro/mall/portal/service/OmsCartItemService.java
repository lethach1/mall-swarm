package com.macro.mall.portal.service;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartProduct;
import com.macro.mall.portal.domain.CartPromotionItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Shopping cart management Service
 * Created by macro on 2018/8/2.
 */
public interface OmsCartItemService {
    /**
     * Check if the product exists in the cart; if yes, increase quantity; if no, add to cart
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * Get cart list by member ID
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * Get cart list including promotion information
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * Update quantity of a cart item
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * Batch delete products from cart
     */
    int delete(Long memberId,List<Long> ids);

    /**
     * Get product information for selecting product specifications in cart
     */
    CartProduct getCartProduct(Long productId);

    /**
     * Update product specifications in cart
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * Clear shopping cart
     */
    int clear(Long memberId);
}
