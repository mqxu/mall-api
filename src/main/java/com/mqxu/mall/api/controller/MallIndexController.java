package com.mqxu.mall.api.controller;

import com.mqxu.mall.api.common.Constants;
import com.mqxu.mall.api.common.IndexConfigTypeEnum;
import com.mqxu.mall.api.controller.vo.IndexInfoVO;
import com.mqxu.mall.api.controller.vo.MallIndexCarouselVO;
import com.mqxu.mall.api.controller.vo.MallIndexGoodsVO;
import com.mqxu.mall.api.service.MallCarouselService;
import com.mqxu.mall.api.service.MallIndexConfigService;
import com.mqxu.mall.api.util.Result;
import com.mqxu.mall.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-24
 **/
@RestController
@Api(value = "v1", tags = "3.楼楼商城首页接口")
@RequestMapping("/api/v1")
public class MallIndexController {
    @Resource
    private MallCarouselService mallCarouselService;

    @Resource
    private MallIndexConfigService mallIndexConfigService;

    @GetMapping("/index-infos")
    @ApiOperation(value = "获取首页数据", notes = "轮播图、热销、新品、推荐等")
    public Result indexInfo() {
        IndexInfoVO indexInfoVO = new IndexInfoVO();
        List<MallIndexCarouselVO> carousels = mallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        List<MallIndexGoodsVO> hotGoods = mallIndexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        List<MallIndexGoodsVO> newGoods = mallIndexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        List<MallIndexGoodsVO> recommendGoods = mallIndexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMEND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
        indexInfoVO.setCarousels(carousels);
        indexInfoVO.setHotGoods(hotGoods);
        indexInfoVO.setNewGoods(newGoods);
        indexInfoVO.setRecommendGoods(recommendGoods);
        return ResultGenerator.genSuccessResult(indexInfoVO);
    }
}
