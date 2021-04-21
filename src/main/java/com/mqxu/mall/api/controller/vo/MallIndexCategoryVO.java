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
public class MallIndexCategoryVO implements Serializable {
    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("轮播图点击后的跳转路径")
    private String redirectUrl;
}
