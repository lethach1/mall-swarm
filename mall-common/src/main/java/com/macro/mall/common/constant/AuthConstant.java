package com.macro.mall.common.constant;

/**
 * Permission related constant definitions
 * Created by macro on 2020/6/19.
 */
public interface AuthConstant {

    /**
     * JWT authority prefix
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT authority claim attribute
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * Backend admin client_id
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * Frontend portal client_id
     */
    String PORTAL_CLIENT_ID = "portal-app";

    /**
     * Backend admin API path pattern
     */
    String ADMIN_URL_PATTERN = "/mall-admin/**";

    /**
     * Redis cache permission rule (path -> resource)
     */
    String PATH_RESOURCE_MAP = "auth:pathResourceMap";

    /**
     * Auth info Http request header
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT token prefix
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * User info Http request header
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * Member info stored in sa-token session
     */
    String STP_MEMBER_INFO = "memberInfo";

    /**
     * Admin info stored in sa-token session
     */
    String STP_ADMIN_INFO = "adminInfo";

}
