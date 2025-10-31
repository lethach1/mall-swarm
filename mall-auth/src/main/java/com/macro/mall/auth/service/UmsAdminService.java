package com.macro.mall.auth.service;

import com.macro.mall.auth.domain.UmsAdminLoginParam;
import com.macro.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author macrozheng
 * @description Remote service for admin user operations
 * @date 2024/1/30
 * @github https://github.com/macrozheng
 */
@FeignClient("mall-admin")
public interface UmsAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam);
}
