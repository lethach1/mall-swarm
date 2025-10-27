package com.macro.mall.portal.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author macrozheng
 * @description Alipay Payment Related Configuration
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {
    /**
     * Alipay Gateway
     */
    private String gatewayUrl;
    /**
     * Application ID
     */
    private String appId;
    /**
     * Application Private Key
     */
    private String appPrivateKey;
    /**
     * Alipay Public Key
     */
    private String alipayPublicKey;
    /**
     * Return URL after user confirms payment (Alipay calls this page)
     * Development environment: http://localhost:8060/#/pages/money/paySuccess
     */
    private String returnUrl;
    /**
     * Asynchronous notification callback URL after successful payment (must be publicly accessible)
     * Development environment: http://localhost:8085/alipay/notify
     */
    private String notifyUrl;
    /**
     * Parameter return format, only supports JSON
     */
    private String format = "JSON";
    /**
     * Encoding format used for requests
     */
    private String charset = "UTF-8";
    /**
     * Signature algorithm type used to generate signature string
     */
    private String signType = "RSA2";
}
