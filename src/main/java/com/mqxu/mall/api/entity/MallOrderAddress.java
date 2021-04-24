package com.mqxu.mall.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单收货地址关联表
 * @author mqxu
 * @TableName tb_mall_order_address
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_mall_order_address")
public class MallOrderAddress implements Serializable {
    /**
     * 
     */
    @TableId
    private Long orderId;

    /**
     * 收货人姓名
     */
    private String userName;

    /**
     * 收货人手机号
     */
    private String userPhone;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 城
     */
    private String cityName;

    /**
     * 区
     */
    private String regionName;

    /**
     * 收件详细地址(街道/楼宇/单元)
     */
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}