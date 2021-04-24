package com.mqxu.mall.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mqxu.mall.api.controller.vo.MallIndexGoodsVO;
import com.mqxu.mall.api.entity.MallGoodsInfo;
import com.mqxu.mall.api.entity.MallIndexConfig;
import com.mqxu.mall.api.mapper.MallGoodsInfoMapper;
import com.mqxu.mall.api.mapper.MallIndexConfigMapper;
import com.mqxu.mall.api.service.MallIndexConfigService;
import com.mqxu.mall.api.util.BaseBeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: MallIndexConfigServiceImpl
 * @author: mqxu
 * @since: 2021-04-24
 **/
@Service
public class MallIndexConfigServiceImpl implements MallIndexConfigService {
    @Resource
    private MallIndexConfigMapper mallIndexConfigMapper;
    @Resource
    private MallGoodsInfoMapper mallGoodsInfoMapper;


    @Override
    public List<MallIndexGoodsVO> getConfigGoodsForIndex(int configType, int number) {
        List<MallIndexGoodsVO> indexInfoVOList = new ArrayList<>(number);
        QueryWrapper<MallIndexConfig> query = new QueryWrapper<>();
        query.eq("config_type", configType);
        query.eq("is_deleted", 0);
        query.orderByDesc("config_rank");
        //根据指定配置类型、未被逻辑删除并按配置排行降序排列查询到的数据
        List<MallIndexConfig> indexConfigList = mallIndexConfigMapper.selectList(query);
        if (!CollectionUtils.isEmpty(indexConfigList)) {
            //取出所有的goodsId
            List<Long> goodsIds = indexConfigList.stream().map(MallIndexConfig::getGoodsId).collect(Collectors.toList());
            List<MallGoodsInfo> mallGoods = mallGoodsInfoMapper.selectBatchIds(goodsIds);
            indexInfoVOList = BaseBeanUtil.copyList(mallGoods, MallIndexGoodsVO.class);
            for (MallIndexGoodsVO infoVo : indexInfoVOList) {
                String goodsName = infoVo.getGoodsName();
                String goodsIntro = infoVo.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 30) {
                    goodsName = goodsName.substring(0, 30) + "...";
                    infoVo.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 22) {
                    goodsIntro = goodsIntro.substring(0, 22) + "...";
                    infoVo.setGoodsIntro(goodsIntro);
                }
            }
        }
        return indexInfoVOList;
    }
}
