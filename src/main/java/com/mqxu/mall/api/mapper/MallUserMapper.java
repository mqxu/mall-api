package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallUser;

import java.util.List;

/**
 * @author mqxu
 * @Entity com.mqxu.mall.api.entity.MallUser
 */
public interface MallUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

    List<MallUser> selectAll();

}




