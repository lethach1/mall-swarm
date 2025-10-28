package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Callback result for OSS file upload
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @Schema(title = "File name")
    private String filename;
    @Schema(title = "File size")
    private String size;
    @Schema(title = "File mimeType")
    private String mimeType;
    @Schema(title = "Image width")
    private String width;
    @Schema(title = "Image height")
    private String height;
}
