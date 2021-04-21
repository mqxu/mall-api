package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallAdminUser;

/**
 * @author mqxu
 * @Entity com.mqxu.mall.api.entity.MallAdminUser
 */
public interface MallAdminUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallAdminUser record);

    int insertSelective(MallAdminUser record);

    MallAdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallAdminUser record);

    int updateByPrimaryKey(MallAdminUser record);

}




