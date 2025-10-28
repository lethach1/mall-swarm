package com.macro.mall.dao;

import com.macro.mall.model.UmsAdminRoleRelation;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for admin user and role management
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminRoleRelationDao {
    /**
     * Batch insert user-role relations
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * Get all roles for user
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * Get all accessible resources for user
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * Get list of user IDs related to resource
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
