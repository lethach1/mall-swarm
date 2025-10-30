package com.macro.mall.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Log wrapper for Controller layer
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WebLog {
    /**
     * Operation description
     */
    private String description;

    /**
     * Operating user
     */
    private String username;

    /**
     * Operation time
     */
    private Long startTime;

    /**
     * Time consumed
     */
    private Integer spendTime;

    /**
     * Root path
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * Request type
     */
    private String method;

    /**
     * IP address
     */
    private String ip;

    /**
     * Request parameter
     */
    private Object parameter;

    /**
     * Return result
     */
    private Object result;

}
