package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Parameters for modifying order fee information
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    @Schema(title = "Order ID")
    private Long orderId;
    @Schema(title = "Freight amount")
    private BigDecimal freightAmount;
    @Schema(title = "Discount amount adjusted in admin backend")
    private BigDecimal discountAmount;
    @Schema(title = "Order status: 0->Pending payment; 1->Pending shipment; 2->Shipped; 3->Completed; 4->Closed; 5->Invalid order")
    private Integer status;
}
