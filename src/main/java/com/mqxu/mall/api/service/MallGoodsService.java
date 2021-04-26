package com.mqxu.mall.api.service;

import com.mqxu.mall.api.entity.MallGoodsInfo;
import com.mqxu.mall.api.util.PageQueryUtil;
import com.mqxu.mall.api.util.PageResult;

/**
 * @description: MallGoodsService
 * @author: mqxu
 * @since: 2021-04-26
 **/
public interface MallGoodsService {
    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return 商品详情
     */
    MallGoodsInfo getMallGoodsById(Long id);

    /**
     * 商品搜索
     *
     * @param pageUtil 分页工具
     * @return 分页结果
     */
    PageResult searchMallGoods(PageQueryUtil pageUtil);
}
