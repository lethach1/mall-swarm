package com.macro.mall.service;

import com.macro.mall.model.CmsSubject;

import java.util.List;

/**
 * Product subject management Service
 * Created by macro on 2018/6/1.
 */
public interface CmsSubjectService {
    /**
     * List all subjects
     */
    List<CmsSubject> listAll();

    /**
     * List subjects with pagination
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}
