package com.macro.mall.service;

import com.macro.mall.dto.*;
import com.macro.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Order management Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderService {
    /**
     * Query orders
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * Batch delivery
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * Batch close orders
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * Batch delete orders
     */
    int delete(List<Long> ids);

    /**
     * Get specified order details
     */
    OmsOrderDetail detail(Long id);

    /**
     * Update order receiver information
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * Update order cost information
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * Update order note
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);
}
