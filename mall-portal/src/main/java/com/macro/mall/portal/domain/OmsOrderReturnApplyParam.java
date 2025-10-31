package com.macro.mall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Parameters for applying for order return
 * Created by macro on 2018/10/17.
 */
@Getter
@Setter
public class OmsOrderReturnApplyParam {
    @Schema(title = "Order ID")
    private Long orderId;
    @Schema(title = "Returned product ID")
    private Long productId;
    @Schema(title = "Order number")
    private String orderSn;
    @Schema(title = "Member username")
    private String memberUsername;
    @Schema(title = "Return applicant name")
    private String returnName;
    @Schema(title = "Return applicant phone")
    private String returnPhone;
    @Schema(title = "Product image")
    private String productPic;
    @Schema(title = "Product name")
    private String productName;
    @Schema(title = "Product brand")
    private String productBrand;
    @Schema(title = "Product sale attributes: e.g., color: red; size: XL")
    private String productAttr;
    @Schema(title = "Return quantity")
    private Integer productCount;
    @Schema(title = "Product unit price")
    private BigDecimal productPrice;
    @Schema(title = "Actual paid unit price")
    private BigDecimal productRealPrice;
    @Schema(title = "Reason")
    private String reason;
    @Schema(title = "Description")
    private String description;
    @Schema(title = "Voucher images, separated by commas")
    private String proofPics;

}
