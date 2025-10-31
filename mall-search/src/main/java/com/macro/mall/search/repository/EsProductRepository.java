package com.macro.mall.search.repository;

import com.macro.mall.search.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ES operation class for searching products
 * Created by macro on 2018/6/19.
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * Search query
     *
     * @param name              Product name
     * @param subTitle          Product subtitle
     * @param keywords          Product keywords
     * @param page              Paging info
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords,Pageable page);

}
