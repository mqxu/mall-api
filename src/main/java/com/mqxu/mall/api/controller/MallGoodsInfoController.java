//package com.mqxu.mall.api.controller;
//
//import com.mqxu.mall.api.common.Constants;
//import com.mqxu.mall.api.common.MallException;
//import com.mqxu.mall.api.common.ServiceResultEnum;
//import com.mqxu.mall.api.config.annotation.TokenToMallUser;
//import com.mqxu.mall.api.controller.vo.MallGoodsDetailVO;
//import com.mqxu.mall.api.controller.vo.MallSearchGoodsVO;
//import com.mqxu.mall.api.entity.MallGoodsInfo;
//import com.mqxu.mall.api.entity.MallUser;
//import com.mqxu.mall.api.service.MallGoodsService;
//import com.mqxu.mall.api.util.*;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description:
// * @author: mqxu
// * @since: 2021-04-26
// **/
//@RestController
//@Api(value = "v1", tags = "5.楼楼商城商品相关接口")
//@RequestMapping("/api/v1")
//@Slf4j
//public class MallGoodsInfoController {
//    @Resource
//    private MallGoodsService mallGoodsService;
//
//    @GetMapping("/search")
//    @ApiOperation(value = "商品搜索接口", notes = "根据关键字和分类id进行搜索")
//    public Result<PageResult<List<MallSearchGoodsVO>>> search(@RequestParam(required = false) @ApiParam(value = "搜索关键字") String keyword,
//                                                              @RequestParam(required = false) @ApiParam(value = "分类id") Long goodsCategoryId,
//                                                              @RequestParam(required = false) @ApiParam(value = "orderBy") String orderBy,
//                                                              @RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
//                                                              @TokenToMallUser MallUser loginMallUser) {
//
//        log.info("goods search api,keyword={},goodsCategoryId={},orderBy={},pageNumber={},userId={}", keyword, goodsCategoryId, orderBy, pageNumber, loginMallUser.getUserId());
//        // 参数map
//        Map<String, Object> params = new HashMap<>(4);
//        // 两个搜索参数都为空，直接返回异常
//        if (goodsCategoryId == null && keyword.isEmpty()) {
//            MallException.fail("非法的搜索参数");
//        }
//        // 页面参数非法，直接置为第一页
//        if (pageNumber == null || pageNumber < 1) {
//            pageNumber = 1;
//        }
//        // 给分页工具传参
//        params.put("goodsCategoryId", goodsCategoryId);
//        params.put("page", pageNumber);
//        params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
//        //对keyword做过滤 去掉空格
//        if (keyword.isEmpty()) {
//            params.put("keyword", keyword);
//        }
//        if (orderBy.isEmpty()) {
//            params.put("orderBy", orderBy);
//        }
//        //搜索上架状态下的商品
//        params.put("goodsSellStatus", Constants.SELL_STATUS_UP);
//        //封装商品数据
//        PageQueryUtil pageUtil = new PageQueryUtil(params);
//        return ResultGenerator.genSuccessResult(mallGoodsService.searchMallGoods(pageUtil));
//    }
//
//    @GetMapping("/goods/detail/{goodsId}")
//    @ApiOperation(value = "商品详情接口", notes = "传参为商品id")
//    public Result<MallGoodsDetailVO> goodsDetail(@ApiParam(value = "商品id") @PathVariable("goodsId") Long goodsId, @TokenToMallUser MallUser loginMallUser) {
//        log.info("goods detail api,goodsId={},userId={}", goodsId, loginMallUser.getUserId());
//        if (goodsId < 1) {
//            return ResultGenerator.genFailResult("参数异常");
//        }
//        MallGoodsInfo goods = mallGoodsService.getMallGoodsById(goodsId);
//        if (goods == null) {
//            return ResultGenerator.genFailResult("参数异常");
//        }
//        if (Constants.SELL_STATUS_UP != goods.getGoodsSellStatus()) {
//            MallException.fail(ServiceResultEnum.GOODS_PUT_DOWN.getResult());
//        }
//        MallGoodsDetailVO goodsDetailVO = new MallGoodsDetailVO();
//        BaseBeanUtil.copyProperties(goods, goodsDetailVO);
//        goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
//        return ResultGenerator.genSuccessResult(goodsDetailVO);
//    }
//}
