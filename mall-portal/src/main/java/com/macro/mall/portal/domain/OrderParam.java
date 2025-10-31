package com.macro.mall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Parameters passed when creating an order
 * Created by macro on 2018/8/30.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderParam {
    @Schema(title = "Shipping address ID")
    private Long memberReceiveAddressId;
    @Schema(title = "Coupon ID")
    private Long couponId;
    @Schema(title = "Integration points to use")
    private Integer useIntegration;
    @Schema(title = "Payment method")
    private Integer payType;
    @Schema(title = "Selected cart item IDs")
    private List<Long> cartIds;
}
