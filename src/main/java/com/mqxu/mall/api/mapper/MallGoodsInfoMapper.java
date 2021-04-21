package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallGoodsInfo;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallGoodsInfo
 */
public interface MallGoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsInfo record);

    int insertSelective(MallGoodsInfo record);

    MallGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsInfo record);

    int updateByPrimaryKey(MallGoodsInfo record);

}




