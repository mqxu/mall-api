package com.mqxu.mall.api.service.impl;

import com.mqxu.mall.api.controller.vo.MallSearchGoodsVO;
import com.mqxu.mall.api.entity.MallGoodsInfo;
import com.mqxu.mall.api.mapper.MallGoodsInfoMapper;
import com.mqxu.mall.api.service.MallGoodsService;
import com.mqxu.mall.api.util.BaseBeanUtil;
import com.mqxu.mall.api.util.PageQueryUtil;
import com.mqxu.mall.api.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-26
 **/
@Service
public class MallGoodsServiceImpl implements MallGoodsService {
    @Resource
    private MallGoodsInfoMapper mallGoodsInfoMapper;

    @Override
    public MallGoodsInfo getMallGoodsById(Long id) {
        return mallGoodsInfoMapper.selectById(id);
    }

    @Override
    public PageResult searchMallGoods(PageQueryUtil pageUtil) {
        List<MallGoodsInfo> goodsList = mallGoodsInfoMapper.findMallGoodsListBySearch(pageUtil);
        int total = mallGoodsInfoMapper.getTotalMallGoodsBySearch(pageUtil);
        List<MallSearchGoodsVO> mallSearchGoodsVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsList)) {
            mallSearchGoodsVOList = BaseBeanUtil.copyList(goodsList, MallSearchGoodsVO.class);
            for (MallSearchGoodsVO mallSearchGoodsVO : mallSearchGoodsVOList) {
                String goodsName = mallSearchGoodsVO.getGoodsName();
                String goodsIntro = mallSearchGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    mallSearchGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    mallSearchGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        return new PageResult(mallSearchGoodsVOList, total, pageUtil.getLimit(), pageUtil.getPage());
    }
}
