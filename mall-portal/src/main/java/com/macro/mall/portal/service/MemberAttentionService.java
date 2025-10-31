package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Member brand attention Service
 * Created by macro on 2018/8/2.
 */
public interface MemberAttentionService {
    /**
     * Add brand attention
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * Cancel brand attention
     */
    int delete(Long brandId);

    /**
     * Get user's attention list
     */
    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);

    /**
     * Get user's attention details
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * Clear attention list
     */
    void clear();
}
