package com.macro.mall.service;

import com.macro.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * Member level management Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberLevelService {
    /**
     * Get all member levels
     * @param defaultStatus whether it is the default member
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
