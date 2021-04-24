package com.mqxu.mall.api.service.impl;

import com.mqxu.mall.api.controller.vo.MallIndexCarouselVO;
import com.mqxu.mall.api.entity.MallCarousel;
import com.mqxu.mall.api.mapper.MallCarouselMapper;
import com.mqxu.mall.api.service.MallCarouselService;
import com.mqxu.mall.api.util.BaseBeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-24
 **/
@Service
public class MallCarouselServiceImpl  implements MallCarouselService {
    @Resource
    private MallCarouselMapper mallCarouselMapper;

    @Override
    public List<MallIndexCarouselVO> getCarouselsForIndex(int number) {
        List<MallIndexCarouselVO> list = new ArrayList<>(number);
        List<MallCarousel> carousels = mallCarouselMapper.findCarouselsByNum(number);
        if (!CollectionUtils.isEmpty(carousels)) {
            list = BaseBeanUtil.copyList(carousels, MallIndexCarouselVO.class);
        }
        return list;
    }
}
