package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Confirm receipt submission parameters
 * Created by macro on 2018/10/18.
 */
@Getter
@Setter
public class OmsUpdateStatusParam {
    @Schema(title = "Service order number")
    private Long id;
    @Schema(title = "Company address ID")
    private Long companyAddressId;
    @Schema(title = "Confirmed refund amount")
    private BigDecimal returnAmount;
    @Schema(title = "Handling note")
    private String handleNote;
    @Schema(title = "Handler")
    private String handleMan;
    @Schema(title = "Receiving note")
    private String receiveNote;
    @Schema(title = "Receiver")
    private String receiveMan;
    @Schema(title = "Application status: 1->Returning; 2->Completed; 3->Rejected")
    private Integer status;
}
