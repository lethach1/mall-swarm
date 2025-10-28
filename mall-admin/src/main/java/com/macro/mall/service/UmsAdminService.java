package com.macro.mall.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.UpdateAdminPasswordParam;
import com.macro.mall.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Admin management Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    /**
     * Get admin by username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Register
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * Login
     * @param username username
     * @param password password
     */
    SaTokenInfo login(String username, String password);

    /**
     * Get user by ID
     */
    UmsAdmin getItem(Long id);

    /**
     * Paginated query by username or nickname
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Update specified user information
     */
    int update(Long id, UmsAdmin admin);

    /**
     * Delete specified user
     */
    int delete(Long id);

    /**
     * Update user-role relations
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * Get roles for user
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * Get accessible resources for specified user
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * Update password
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * Get current logged-in admin
     */
    UmsAdmin getCurrentAdmin();

    /**
     * Logout
     */
    void logout();
}
