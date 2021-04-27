//package com.mqxu.mall.api.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@Slf4j
//class MallUserServiceTest {
//    @Resource
//    private MallUserService mallUserService;
//
//    @Test
//    void register() {
//        //String register = mallUserService.register("13951901489", "123123");
//        //log.info(register);
//        //assertEquals("success", register);
//    }
//
//    @Test
//    void login() {
//        String login = mallUserService.login("13951901489", "4297f44b13955235245b2497399d7a93");
//        //返回了登录用户的token，会在tb_mall_user_token表生成一条token记录
//        log.info(login);
//    }
//
//    @Test
//    void updateUserInfo() {
//        //修改用户信息,可修改的字段为MallUserUpdateParam的属性
//        //MallUserUpdateParam mup = new MallUserUpdateParam();
//        //mup.setNickName("新昵称");
//        //mup.setPasswordMd5("e10adc3949ba59abbe56e057f20f883e");
//        //mup.setIntroduceSign("开到荼蘼");
//        //Boolean result = mallUserService.updateUserInfo(mup, 46L);
//        //log.info(result.toString());
//        //assertTrue(result);
//    }
//
//    @Test
//    void logout() {
//        //会在tb_mall_user_token表中删掉10号用户的一条token数据
//        //Boolean logout = mallUserService.logout(46L);
//        //log.info(logout.toString());
//        //assertTrue(logout);
//    }
//}