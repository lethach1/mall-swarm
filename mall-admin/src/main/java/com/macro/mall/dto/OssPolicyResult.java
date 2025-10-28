package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Result of obtaining OSS upload authorization
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssPolicyResult {
    @Schema(title = "User identifier used in access authentication")
    private String accessKeyId;
    @Schema(title = "User upload policy, Base64-encoded string")
    private String policy;
    @Schema(title = "Signature for the policy")
    private String signature;
    @Schema(title = "Upload folder path prefix")
    private String dir;
    @Schema(title = "OSS external service domain")
    private String host;
    @Schema(title = "Callback settings after successful upload")
    private String callback;
}
