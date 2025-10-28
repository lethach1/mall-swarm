package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Order delivery parameters
 * Created by macro on 2018/10/12.
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {
    @Schema(title = "Order ID")
    private Long orderId;
    @Schema(title = "Logistics company")
    private String deliveryCompany;
    @Schema(title = "Logistics tracking number")
    private String deliverySn;
}
