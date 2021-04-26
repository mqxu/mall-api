package com.mqxu.mall.api.service;

import com.mqxu.mall.api.controller.vo.MallIndexCategoryVO;
import com.mqxu.mall.api.entity.MallGoodsCategory;

import java.util.List;

/**
 * @description: 分类接口
 * @author: mqxu
 * @since: 2021-04-26
 **/
public interface MallGoodsCategoryService {
    /**
     * 新增商品分类信息
     *
     * @param goodsCategory 分类信息
     * @return String
     */
    String saveCategory(MallGoodsCategory goodsCategory);

    /**
     * 修改商品分类信息
     *
     * @param goodsCategory 分类信息
     * @return String
     */
    String updateGoodsCategory(MallGoodsCategory goodsCategory);

    /**
     * 根据id查询商品分类
     *
     * @param id 分类id
     * @return 商品分类
     */
    MallGoodsCategory getGoodsCategoryById(Long id);

    /**
     * 批量删除
     *
     * @param ids id数组
     * @return boolean
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return 分类数据
     */
    List<MallIndexCategoryVO> getCategoriesForIndex();
}
