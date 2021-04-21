package com.mqxu.mall.api.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-21
 **/
@Data
public class MallIndexConfigGoodsVO {
    @ApiModelProperty("当前一级分类id")
    private Long categoryId;

    @ApiModelProperty("当前分类级别")
    private Byte categoryLevel;

    @ApiModelProperty("当前一级分类名称")
    private String categoryName;

    @ApiModelProperty("二级分类列表")
    private List<SecondLevelCategoryVO> secondLevelCategoryVos;
}
