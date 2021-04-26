package com.mqxu.mall.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mqxu.mall.api.entity.MallGoodsInfo;
import com.mqxu.mall.api.util.PageQueryUtil;

import java.util.List;

/**
 * @author mqxu
 * @Entity com.mqxu.mall.api.entity.TbMallGoodsInfo
 */
public interface MallGoodsInfoMapper extends BaseMapper<MallGoodsInfo> {
    /**
     * 搜索并分页
     *
     * @param pageUtil 分页工具
     * @return 分页搜索结果
     */
    List<MallGoodsInfo> findMallGoodsListBySearch(PageQueryUtil pageUtil);

    /**
     * 搜索结果数量
     *
     * @param pageUtil 分页工具
     * @return int
     */
    int getTotalMallGoodsBySearch(PageQueryUtil pageUtil);
}




