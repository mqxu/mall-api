package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallUser;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallUser
 */
public interface MallUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

}




