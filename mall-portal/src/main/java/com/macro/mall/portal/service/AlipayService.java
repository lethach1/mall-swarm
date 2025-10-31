package com.macro.mall.portal.service;


import com.macro.mall.portal.domain.AliPayParam;

import java.util.Map;

/**
 * @auther macrozheng
 * @description Alipay payment Service
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
public interface AlipayService {
    /**
     * Generate payment page for desktop based on submitted parameters
     */
    String pay(AliPayParam aliPayParam);

    /**
     * Handle Alipay asynchronous callback
     */
    String notify(Map<String, String> params);

    /**
     * Query Alipay transaction status
     * @param outTradeNo Merchant order number
     * @param tradeNo Alipay transaction number
     * @return Alipay transaction status
     */
    String query(String outTradeNo, String tradeNo);

    /**
     * Generate payment page for mobile based on submitted parameters
     */
    String webPay(AliPayParam aliPayParam);
}
