package com.macro.mall.service;

import com.macro.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * Shipping address management Service
 * Created by macro on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * List all shipping addresses
     */
    List<OmsCompanyAddress> list();
}
