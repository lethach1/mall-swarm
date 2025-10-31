package com.macro.mall.auth.service;

import com.macro.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author macrozheng
 * @description Remote service for portal member operations
 * @date 2024/1/30
 * @github https://github.com/macrozheng
 */
@FeignClient("mall-portal")
public interface UmsMemberService {
    @PostMapping("/sso/login")
    CommonResult login(@RequestParam("username") String username, @RequestParam("password") String password);
}
