package com.macro.mall.dao;

import com.macro.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for product and subject relation operations
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectProductRelationDao {
    /**
     * Batch create
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
