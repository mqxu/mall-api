package com.mqxu.mall.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_mall_shopping_cart_item
 */
@Data
public class MallShoppingCartItem implements Serializable {
    /**
     * 购物项主键id
     */
    private Long cartItemId;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 关联商品id
     */
    private Long goodsId;

    /**
     * 数量(最大为5)
     */
    private Integer goodsCount;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Byte isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最新修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}