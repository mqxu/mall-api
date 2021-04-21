package com.mqxu.mall.api.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class MallUserServiceTest {
    @Resource
    private MallUserService mallUserService;

    @Test
    void register() {
        String register = mallUserService.register("13300001111", "123123");
        log.info(register);
    }

    @Test
    void login() {
        String register = mallUserService.login("13300001111", "4297f44b13955235245b2497399d7a93");
        log.info(register);
    }

    @Test
    void updateUserInfo() {

    }

    @Test
    void logout() {
        Boolean logout = mallUserService.logout(9L);
        log.info(logout.toString());
    }
}