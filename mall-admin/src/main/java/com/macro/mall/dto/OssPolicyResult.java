package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response for obtaining OSS upload authorization
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssPolicyResult {
    @Schema(title = "User identifier used for access authentication")
    private String accessKeyId;
    @Schema(title = "Base64-encoded policy for form upload")
    private String policy;
    @Schema(title = "Signature for the policy")
    private String signature;
    @Schema(title = "Upload directory prefix")
    private String dir;
    @Schema(title = "OSS external service host")
    private String host;
    @Schema(title = "Callback settings after successful upload")
    private String callback;
}
