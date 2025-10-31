package com.macro.mall.service;

import com.macro.mall.model.OmsOrderSetting;

/**
 * Order setting Service
 * Created by macro on 2018/10/16.
 */
public interface OmsOrderSettingService {
    /**
     * Get specified order setting
     */
    OmsOrderSetting getItem(Long id);

    /**
     * Update specified order setting
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
