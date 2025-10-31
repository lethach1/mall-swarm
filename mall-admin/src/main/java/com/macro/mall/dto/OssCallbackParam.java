package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * OSS upload success callback parameters
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackParam {
    @Schema(title = "Callback URL")
    private String callbackUrl;
    @Schema(title = "Callback body passed in request")
    private String callbackBody;
    @Schema(title = "Callback body type, e.g., form-data")
    private String callbackBodyType;
}
