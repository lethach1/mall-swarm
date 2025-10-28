package com.macro.mall.dao;

import com.macro.mall.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for preference and product relation operations
 * Created by macro on 2018/4/26.
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * Batch create
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
