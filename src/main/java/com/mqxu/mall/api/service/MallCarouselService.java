package com.mqxu.mall.api.service;

import com.mqxu.mall.api.controller.vo.MallIndexCarouselVO;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-24
 **/
public interface MallCarouselService {
    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number 数量
     * @return 轮播图集合
     */
    List<MallIndexCarouselVO> getCarouselsForIndex(int number);

}
