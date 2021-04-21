package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallUserAddress;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallUserAddress
 */
public interface MallUserAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    MallUserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);

}




