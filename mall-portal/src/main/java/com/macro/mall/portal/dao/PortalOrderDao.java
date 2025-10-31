package com.macro.mall.portal.dao;

import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for frontend orders
 * Created by macro on 2018/9/4.
 */
public interface PortalOrderDao {
    /**
     * Get order and order item details
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * Update locked and actual stock in the pms_sku_stock table
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * Get timed-out orders
     * @param minute Timeout threshold in minutes
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * Batch update order status
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * Release stock lock for canceled orders
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);

}
