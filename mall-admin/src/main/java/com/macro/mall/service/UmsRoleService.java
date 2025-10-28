package com.macro.mall.service;

import com.macro.mall.model.UmsMenu;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Backend role management Service
 * Created by macro on 2018/9/30.
 */
public interface UmsRoleService {
    /**
     * Add role
     */
    int create(UmsRole role);

    /**
     * Update role information
     */
    int update(Long id, UmsRole role);

    /**
     * Batch delete roles
     */
    int delete(List<Long> ids);

    /**
     * Get all roles
     */
    List<UmsRole> list();

    /**
     * Get role list with pagination
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Get menus by admin ID
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * Get menus related to the role
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * Get resources related to the role
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * Assign menus to the role
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * Assign resources to the role
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
