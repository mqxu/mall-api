package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallUserToken;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallUserToken
 */
public interface MallUserTokenMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUserToken record);

    int insertSelective(MallUserToken record);

    MallUserToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserToken record);

    int updateByPrimaryKey(MallUserToken record);

}




