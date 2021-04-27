package com.mqxu.mall.api.service;

import com.mqxu.mall.api.entity.MallLoginLog;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-27
 **/
public interface MallLoginLogService {
    /**
     * 保存登录日志
     *
     * @param mallLoginLog 登录日志
     * @return Boolean
     */
    Boolean saveLog(MallLoginLog mallLoginLog);
}
