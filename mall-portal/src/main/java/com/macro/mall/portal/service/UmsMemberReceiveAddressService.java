package com.macro.mall.portal.service;

import com.macro.mall.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Member address management Service
 * Created by macro on 2018/8/28.
 */
public interface UmsMemberReceiveAddressService {
    /**
     * Add shipping address
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * Delete shipping address
     * @param id Address table ID
     */
    int delete(Long id);

    /**
     * Update shipping address
     * @param id Address table ID
     * @param address Updated shipping address information
     */
    @Transactional
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * Get current member's shipping addresses
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * Get address details
     * @param id Address ID
     */
    UmsMemberReceiveAddress getItem(Long id);
}
