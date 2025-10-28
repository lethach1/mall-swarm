package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Callback parameters after successful OSS upload
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackParam {
    @Schema(title = "Callback URL")
    private String callbackUrl;
    @Schema(title = "Parameters passed in request during callback")
    private String callbackBody;
    @Schema(title = "Format of parameters during callback, e.g., form submission")
    private String callbackBodyType;
}
