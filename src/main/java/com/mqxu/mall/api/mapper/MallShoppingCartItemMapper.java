package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallShoppingCartItem;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallShoppingCartItem
 */
public interface MallShoppingCartItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    MallShoppingCartItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

}




