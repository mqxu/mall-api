package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallGoodsCategory;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallGoodsCategory
 */
public interface MallGoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsCategory record);

    int insertSelective(MallGoodsCategory record);

    MallGoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsCategory record);

    int updateByPrimaryKey(MallGoodsCategory record);

}




