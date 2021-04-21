package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallOrder;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallOrder
 */
public interface MallOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);

}




