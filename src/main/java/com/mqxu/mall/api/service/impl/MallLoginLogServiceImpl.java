package com.mqxu.mall.api.service.impl;

import com.mqxu.mall.api.entity.MallLoginLog;
import com.mqxu.mall.api.mapper.MallLoginLogMapper;
import com.mqxu.mall.api.service.MallLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mqxu
 * @since: 2021-04-27
 **/
@Service
public class MallLoginLogServiceImpl implements MallLoginLogService {
    @Resource
    private MallLoginLogMapper mallLoginLogMapper;

    @Override
    public Boolean saveLog(MallLoginLog mallLoginLog) {
        return mallLoginLogMapper.insert(mallLoginLog) != 0;
    }
}
