package com.mqxu.mall.api.service.impl;

import com.mqxu.mall.api.common.Constants;
import com.mqxu.mall.api.common.MallCategoryLevelEnum;
import com.mqxu.mall.api.common.ServiceResultEnum;
import com.mqxu.mall.api.controller.vo.MallIndexCategoryVO;
import com.mqxu.mall.api.controller.vo.SecondLevelCategoryVO;
import com.mqxu.mall.api.controller.vo.ThirdLevelCategoryVO;
import com.mqxu.mall.api.entity.MallGoodsCategory;
import com.mqxu.mall.api.mapper.MallGoodsCategoryMapper;
import com.mqxu.mall.api.service.MallGoodsCategoryService;
import com.mqxu.mall.api.util.BaseBeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-26
 **/
@Service
public class MallGoodsCategoryServiceImpl implements MallGoodsCategoryService {
    @Resource
    private MallGoodsCategoryMapper mallGoodsCategoryMapper;

    @Override
    public String saveCategory(MallGoodsCategory goodsCategory) {
        MallGoodsCategory temp = mallGoodsCategoryMapper.selectByLevelAndName(goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
        if (temp != null) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (mallGoodsCategoryMapper.insert(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateGoodsCategory(MallGoodsCategory goodsCategory) {
        MallGoodsCategory temp = mallGoodsCategoryMapper.selectById(goodsCategory.getCategoryId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        MallGoodsCategory temp2 = mallGoodsCategoryMapper.selectByLevelAndName(goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
        if (temp2 != null && !temp2.getCategoryId().equals(goodsCategory.getCategoryId())) {
            //同名且不同id 不能继续修改
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        goodsCategory.setUpdateTime(new Date());
        if (mallGoodsCategoryMapper.updateById(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallGoodsCategory getGoodsCategoryById(Long id) {
        return mallGoodsCategoryMapper.selectById(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        List<Integer> idsList = Arrays.asList(ids);
        //删除分类数据
        return mallGoodsCategoryMapper.deleteBatchIds(idsList) > 0;
    }

    @Override
    public List<MallIndexCategoryVO> getCategoriesForIndex() {
        List<MallIndexCategoryVO> mallIndexCategoryVOList = new ArrayList<>();
        //获取一级分类的固定数量的数据
        List<MallGoodsCategory> firstLevelCategories = mallGoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), MallCategoryLevelEnum.LEVEL_ONE.getLevel(), Constants.INDEX_CATEGORY_NUMBER);
        if (!CollectionUtils.isEmpty(firstLevelCategories)) {
            List<Long> firstLevelCategoryIds = firstLevelCategories.stream().map(MallGoodsCategory::getCategoryId).collect(Collectors.toList());
            //获取二级分类的数据
            List<MallGoodsCategory> secondLevelCategories = mallGoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(firstLevelCategoryIds, MallCategoryLevelEnum.LEVEL_TWO.getLevel(), 0);
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                List<Long> secondLevelCategoryIds = secondLevelCategories.stream().map(MallGoodsCategory::getCategoryId).collect(Collectors.toList());
                //获取三级分类的数据
                List<MallGoodsCategory> thirdLevelCategories = mallGoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(secondLevelCategoryIds, MallCategoryLevelEnum.LEVEL_THREE.getLevel(), 0);
                if (!CollectionUtils.isEmpty(thirdLevelCategories)) {
                    //根据 parentId 将 thirdLevelCategories 分组
                    Map<Long, List<MallGoodsCategory>> thirdLevelCategoryMap = thirdLevelCategories.stream().collect(groupingBy(MallGoodsCategory::getParentId));
                    List<SecondLevelCategoryVO> secondLevelCategoryVOList = new ArrayList<>();
                    //处理二级分类
                    for (MallGoodsCategory secondLevelCategory : secondLevelCategories) {
                        SecondLevelCategoryVO secondLevelCategoryVO = new SecondLevelCategoryVO();
                        BaseBeanUtil.copyProperties(secondLevelCategory, secondLevelCategoryVO);
                        //如果该二级分类下有数据则放入 secondLevelCategoryVOS 对象中
                        if (thirdLevelCategoryMap.containsKey(secondLevelCategory.getCategoryId())) {
                            //根据二级分类的id取出thirdLevelCategoryMap分组中的三级分类list
                            List<MallGoodsCategory> tempGoodsCategories = thirdLevelCategoryMap.get(secondLevelCategory.getCategoryId());
                            secondLevelCategoryVO.setThirdLevelCategoryVos((BaseBeanUtil.copyList(tempGoodsCategories, ThirdLevelCategoryVO.class)));
                            secondLevelCategoryVOList.add(secondLevelCategoryVO);
                        }
                    }
                    //处理一级分类
                    if (!CollectionUtils.isEmpty(secondLevelCategoryVOList)) {
                        //根据 parentId 将 thirdLevelCategories 分组
                        Map<Long, List<SecondLevelCategoryVO>> secondLevelCategoryVoMap = secondLevelCategoryVOList.stream().collect(groupingBy(SecondLevelCategoryVO::getParentId));
                        for (MallGoodsCategory firstCategory : firstLevelCategories) {
                            MallIndexCategoryVO mallIndexCategoryVO = new MallIndexCategoryVO();
                            BaseBeanUtil.copyProperties(firstCategory, mallIndexCategoryVO);
                            //如果该一级分类下有数据则放入 categoryVOS 对象中
                            if (secondLevelCategoryVoMap.containsKey(firstCategory.getCategoryId())) {
                                //根据一级分类的id取出secondLevelCategoryVOMap分组中的二级级分类list
                                List<SecondLevelCategoryVO> tempGoodsCategories = secondLevelCategoryVoMap.get(firstCategory.getCategoryId());
                                mallIndexCategoryVO.setSecondLevelCategoryVos(tempGoodsCategories);
                                mallIndexCategoryVOList.add(mallIndexCategoryVO);
                            }
                        }
                    }
                }
            }
            return mallIndexCategoryVOList;
        } else {
            return null;
        }
    }
}
