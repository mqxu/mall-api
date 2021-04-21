package com.mqxu.mall.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_mall_goods_category
 */
@Data
public class MallGoodsCategory implements Serializable {
    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 分类级别(1-一级分类 2-二级分类 3-三级分类)
     */
    private Byte categoryLevel;

    /**
     * 父分类id
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer categoryRank;

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