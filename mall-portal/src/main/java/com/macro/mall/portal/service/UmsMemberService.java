package com.macro.mall.portal.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.macro.mall.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * Member management Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * Get member by username
     */
    UmsMember getByUsername(String username);

    /**
     * Get member by ID
     */
    UmsMember getById(Long id);

    /**
     * Member registration
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * Generate verification code
     */
    String generateAuthCode(String telephone);

    /**
     * Update password
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * Get current logged-in member
     */
    UmsMember getCurrentMember();

    /**
     * Update member integration points by member ID
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * Get token after login
     */
    SaTokenInfo login(String username, String password);

    /**
     * Logout functionality
     */
    void logout();
}
