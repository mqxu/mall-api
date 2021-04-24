package com.mqxu.mall.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mqxu.mall.api.entity.MallCarousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mqxu
 * @Entity com.mqxu.mall.api.entity.TbMallCarousel
 */
public interface MallCarouselMapper extends BaseMapper<MallCarousel> {
    /**
     * 查询number个轮播图数据
     *
     * @param number 数量
     * @return 轮播图
     */
    List<MallCarousel> findCarouselsByNum(@Param("number") int number);
}




