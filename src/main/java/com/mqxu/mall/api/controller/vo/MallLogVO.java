package com.mqxu.mall.api.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 日志VO
 * @author: mqxu
 * @since: 2021-04-27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MallLogVO {
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("访问接口")
    private String apiUri;

    @ApiModelProperty("平台")
    private String platform;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
