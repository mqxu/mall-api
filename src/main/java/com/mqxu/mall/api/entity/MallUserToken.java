package com.mqxu.mall.api.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_mall_user_token
 */
@Data
public class MallUserToken implements Serializable {
    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * token值(32位字符串)
     */
    private String token;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * token过期时间
     */
    private Date expireTime;

    private static final long serialVersionUID = 1L;
}