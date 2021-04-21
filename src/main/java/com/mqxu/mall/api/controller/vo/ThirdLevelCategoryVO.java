package com.mqxu.mall.api.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-21
 **/
@Data
public class ThirdLevelCategoryVO implements Serializable {

    @ApiModelProperty("当前三级分类id")
    private Long categoryId;

    @ApiModelProperty("当前分类级别")
    private Byte categoryLevel;

    @ApiModelProperty("当前三级分类名称")
    private String categoryName;
}