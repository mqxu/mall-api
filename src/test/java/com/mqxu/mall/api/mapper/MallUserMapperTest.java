package com.mqxu.mall.api.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
@Slf4j
class MallUserMapperTest {
    @Resource
    private MallUserMapper mallUserMapper;

    @Test
    void insert() {
        //MallUser mallUser = MallUser.builder()
        //        .nickName("测试用户")
        //        .loginName("13099990000")
        //        .passwordMd5("e10adc3949ba59abbe56e057f20f883e")
        //        .address("江苏南京")
        //        .introduceSign("测试用户")
        //        .isDeleted((byte) 0)
        //        .lockedFlag((byte) 0)
        //        .createTime(new Date())
        //        .build();
        //int count = mallUserMapper.insert(mallUser);
        //assertEquals(1, count);
    }

    @Test
    void selectByPrimaryKey() {
        //MallUser mallUser = mallUserMapper.selectByPrimaryKey(1L);
        //System.out.println(mallUser);
    }

    @Test
    void selectByLoginName() {
        //MallUser mallUser = mallUserMapper.selectByLoginName("13951905171");
        //log.info("用户信息：" + mallUser);
        //assertEquals(mallUser.getNickName(), "陶然然");
    }

    @Test
    void selectByLoginNameAndPasswd() {
        //MallUser mallUser = mallUserMapper.selectByLoginNameAndPasswd("13951905171", "e10adc3949ba59abbe56e057f20f883e");
        //log.info("用户信息：" + mallUser);
        //assertEquals(mallUser.getNickName(), "陶然然");
    }
}