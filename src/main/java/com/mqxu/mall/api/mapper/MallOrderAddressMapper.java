package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallOrderAddress;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallOrderAddress
 */
public interface MallOrderAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

    MallOrderAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);

}




