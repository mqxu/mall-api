package com.mqxu.mall.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收货地址表
 * @TableName tb_mall_user_address
 */
@Data
public class MallUserAddress implements Serializable {
    /**
     * 
     */
    private Long addressId;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 收货人姓名
     */
    private String userName;

    /**
     * 收货人手机号
     */
    private String userPhone;

    /**
     * 是否为默认 0-非默认 1-是默认
     */
    private Byte defaultFlag;

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

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Byte isDeleted;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}