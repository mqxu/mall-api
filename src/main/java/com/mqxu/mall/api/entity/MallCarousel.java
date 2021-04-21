package com.mqxu.mall.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_mall_carousel
 */
@Data
public class MallCarousel implements Serializable {
    /**
     * 首页轮播图主键id
     */
    private Integer carouselId;

    /**
     * 轮播图
     */
    private String carouselUrl;

    /**
     * 点击后的跳转地址(默认不跳转)
     */
    private String redirectUrl;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer carouselRank;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Byte isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改者id
     */
    private Integer updateUser;

    private static final long serialVersionUID = 1L;
}