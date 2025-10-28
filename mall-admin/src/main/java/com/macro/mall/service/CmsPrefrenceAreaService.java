package com.macro.mall.service;

import com.macro.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * Product preference management Service
 * Created by macro on 2018/6/1.
 */
public interface CmsPrefrenceAreaService {
    /**
     * Get all preference areas
     */
    List<CmsPrefrenceArea> listAll();
}
