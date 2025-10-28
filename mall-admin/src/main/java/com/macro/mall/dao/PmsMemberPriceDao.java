package com.macro.mall.dao;

import com.macro.mall.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for member pricing
 * Created by macro on 2018/4/26.
 */
public interface PmsMemberPriceDao {
    /**
     * Batch create
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
