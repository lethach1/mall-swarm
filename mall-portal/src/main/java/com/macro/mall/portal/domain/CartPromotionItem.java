package com.macro.mall.portal.domain;

import com.macro.mall.model.OmsCartItem;

import java.math.BigDecimal;

/**
 * Created by macro on 2018/8/27.
 * Wrapper for promotion information in the shopping cart
 */
public class CartPromotionItem extends OmsCartItem{
    // Promotion message
    private String promotionMessage;
    // Amount reduced by promotions, per product
    private BigDecimal reduceAmount;
    // Real stock of the product (remaining stock - locked stock)
    private Integer realStock;
    // Reward points granted for purchasing the product
    private Integer integration;
    // Growth value granted for purchasing the product
    private Integer growth;
    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}
