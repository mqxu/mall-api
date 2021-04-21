package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallOrderItem;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallOrderItem
 */
public interface MallOrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);

}




