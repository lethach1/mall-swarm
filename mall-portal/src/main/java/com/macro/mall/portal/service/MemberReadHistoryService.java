package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Member browsing history management Service
 * Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryService {
    /**
     * Create browsing history record
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * Batch delete browsing history records
     */
    int delete(List<String> ids);

    /**
     * Get user's browsing history with pagination
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * Clear browsing history
     */
    void clear();
}
