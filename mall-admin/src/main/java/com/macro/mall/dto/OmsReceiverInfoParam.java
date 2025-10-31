package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Parameters for updating order receiver information
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsReceiverInfoParam {
    @Schema(title = "Order ID")
    private Long orderId;
    @Schema(title = "Receiver name")
    private String receiverName;
    @Schema(title = "Receiver phone")
    private String receiverPhone;
    @Schema(title = "Receiver postcode")
    private String receiverPostCode;
    @Schema(title = "Detailed address")
    private String receiverDetailAddress;
    @Schema(title = "Province/Municipality")
    private String receiverProvince;
    @Schema(title = "City")
    private String receiverCity;
    @Schema(title = "District/Region")
    private String receiverRegion;
    @Schema(title = "Order status: 0->Pending Payment; 1->Pending Delivery; 2->Delivered; 3->Completed; 4->Closed; 5->Invalid")
    private Integer status;
}
