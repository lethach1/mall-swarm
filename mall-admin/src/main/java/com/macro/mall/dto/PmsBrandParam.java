package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

/**
 * Brand parameters
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandParam {
    @NotEmpty
    @Schema(title = "Brand name",required = true)
    private String name;
    @Schema(title = "Brand initial")
    private String firstLetter;
    @Min(value = 0)
    @Schema(title = "Sort order")
    private Integer sort;
    @FlagValidator(value = {"0","1"}, message = "Invalid manufacturer status")
    @Schema(title = "Is manufacturer")
    private Integer factoryStatus;
    @FlagValidator(value = {"0","1"}, message = "Invalid show status")
    @Schema(title = "Is visible")
    private Integer showStatus;
    @NotEmpty
    @Schema(title = "Brand logo",required = true)
    private String logo;
    @Schema(title = "Brand large image")
    private String bigPic;
    @Schema(title = "Brand story")
    private String brandStory;
}
