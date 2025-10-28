package com.macro.mall.service;

import com.macro.mall.model.OmsOrderSetting;

/**
 * Order settings Service
 * Created by macro on 2018/10/16.
 */
public interface OmsOrderSettingService {
    /**
     * Get specified order settings
     */
    OmsOrderSetting getItem(Long id);

    /**
     * Update specified order settings
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
