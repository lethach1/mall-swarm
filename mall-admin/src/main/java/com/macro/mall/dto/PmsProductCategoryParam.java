package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Parameters for adding/updating product categories
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @Schema(title = "Parent category ID")
    private Long parentId;
    @NotEmpty
    @Schema(title = "Product category name",required = true)
    private String name;
    @Schema(title = "Category unit")
    private String productUnit;
    @FlagValidator(value = {"0","1"},message = "Status must be 0 or 1")
    @Schema(title = "Show in navigation")
    private Integer navStatus;
    @FlagValidator(value = {"0","1"},message = "Status must be 0 or 1")
    @Schema(title = "Is visible")
    private Integer showStatus;
    @Min(value = 0)
    @Schema(title = "Sort order")
    private Integer sort;
    @Schema(title = "Icon")
    private String icon;
    @Schema(title = "Keywords")
    private String keywords;
    @Schema(title = "Description")
    private String description;
    @Schema(title = "Related filter attribute IDs")
    private List<Long> productAttributeIdList;
}
