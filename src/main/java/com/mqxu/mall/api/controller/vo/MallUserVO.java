package com.mqxu.mall.api.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mqxu
 * @description: 用户VO类
 * @since: 2021-04-21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MallUserVO implements Serializable {
    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户登录名")
    private String loginName;

    @ApiModelProperty("个性签名")
    private String introduceSign;

    @ApiModelProperty("头像")
    private String avatar;
}
