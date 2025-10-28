package com.macro.mall.dao;

import com.macro.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * Custom DAO for coupon management
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponDao {
    /**
     * Get coupon details including binding relations
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
