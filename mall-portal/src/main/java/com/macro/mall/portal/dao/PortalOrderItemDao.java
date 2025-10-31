package com.macro.mall.portal.dao;

import com.macro.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for order item information
 * Created by macro on 2018/9/3.
 */
public interface PortalOrderItemDao {
    int insertList(@Param("list") List<OmsOrderItem> list);
}
