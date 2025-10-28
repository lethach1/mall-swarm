package com.macro.mall.service;

import com.macro.mall.dto.OssCallbackResult;
import com.macro.mall.dto.OssPolicyResult;

import jakarta.servlet.http.HttpServletRequest;

/**
 * OSS upload management Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    /**
     * Generate OSS upload policy
     */
    OssPolicyResult policy();
    /**
     * OSS upload success callback
     */
    OssCallbackResult callback(HttpServletRequest request);
}
