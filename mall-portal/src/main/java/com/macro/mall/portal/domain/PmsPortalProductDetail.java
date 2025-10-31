package com.macro.mall.portal.domain;

import com.macro.mall.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Frontend product details
 * Created by macro on 2020/4/6.
 */
@Getter
@Setter
public class PmsPortalProductDetail{
    @Schema(title = "Product information")
    private PmsProduct product;
    @Schema(title = "Product brand")
    private PmsBrand brand;
    @Schema(title = "Product attributes and parameters")
    private List<PmsProductAttribute> productAttributeList;
    @Schema(title = "Manually entered product attributes and parameter values")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @Schema(title = "Product SKU stock information")
    private List<PmsSkuStock> skuStockList;
    @Schema(title = "Product ladder pricing settings")
    private List<PmsProductLadder> productLadderList;
    @Schema(title = "Product full reduction pricing settings")
    private List<PmsProductFullReduction> productFullReductionList;
    @Schema(title = "Coupons available for this product")
    private List<SmsCoupon> couponList;
}
