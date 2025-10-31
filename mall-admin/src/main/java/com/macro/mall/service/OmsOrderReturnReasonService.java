package com.macro.mall.service;

import com.macro.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * Return reason management Service
 * Created by macro on 2018/10/17.
 */
public interface OmsOrderReturnReasonService {
    /**
     * Create return reason
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * Update return reason
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * Batch delete return reasons
     */
    int delete(List<Long> ids);

    /**
     * List return reasons with pagination
     */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * Batch update return reason status
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * Get return reason details
     */
    OmsOrderReturnReason getItem(Long id);
}
