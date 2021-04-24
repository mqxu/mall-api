package com.mqxu.mall.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author mqxu
 * @TableName tb_mall_user_token
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_mall_user_token")
public class MallUserToken implements Serializable {
    /**
     * 用户主键id
     */
    @TableId
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