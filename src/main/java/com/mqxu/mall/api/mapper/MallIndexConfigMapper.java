package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallIndexConfig;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallIndexConfig
 */
public interface MallIndexConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallIndexConfig record);

    int insertSelective(MallIndexConfig record);

    MallIndexConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexConfig record);

    int updateByPrimaryKey(MallIndexConfig record);

}




