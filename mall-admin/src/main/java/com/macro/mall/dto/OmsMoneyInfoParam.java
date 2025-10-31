package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Parameters for updating order cost information
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    @Schema(title = "Order ID")
    private Long orderId;
    @Schema(title = "Freight amount")
    private BigDecimal freightAmount;
    @Schema(title = "Admin adjusted discount amount")
    private BigDecimal discountAmount;
    @Schema(title = "Order status: 0->Pending Payment; 1->Pending Delivery; 2->Delivered; 3->Completed; 4->Closed; 5->Invalid")
    private Integer status;
}
