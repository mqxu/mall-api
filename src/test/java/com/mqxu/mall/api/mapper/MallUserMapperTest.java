package com.mqxu.mall.api.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Slf4j
class MallUserMapperTest {
    @Resource
    private MallUserMapper mallUserMapper;

    @Test
    void selectByPrimaryKey() {
        MallUser mallUser = mallUserMapper.selectByPrimaryKey(1L);
        System.out.println(mallUser);
    }

    @Test
    void selectByLoginName() {
        MallUser mallUser = mallUserMapper.selectByLoginName("13951905171");
        log.info("用户信息：" + mallUser);
        assertEquals(mallUser.getNickName(), "陶然然");
    }

    @Test
    void selectByLoginNameAndPasswd() {
        MallUser mallUser = mallUserMapper.selectByLoginNameAndPasswd("13951905171", "e10adc3949ba59abbe56e057f20f883e");
        log.info("用户信息：" + mallUser);
        assertEquals(mallUser.getNickName(), "陶然然");
    }
}