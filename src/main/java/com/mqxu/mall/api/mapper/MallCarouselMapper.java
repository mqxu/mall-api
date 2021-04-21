package com.mqxu.mall.api.mapper;

import com.mqxu.mall.api.entity.MallCarousel;

/**
 * @Entity com.mqxu.mall.api.entity.TbMallCarousel
 */
public interface MallCarouselMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallCarousel record);

    int insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

}




