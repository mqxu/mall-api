package com.mqxu.mall.api.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class MallUserAddressServiceTest {
    @Resource
    private MallUserAddressService mallUserAddressService;

    @Test
    void getMyAddresses() {
        //    List<MallUserAddressVO> myAddresses = mallUserAddressService.getMyAddresses(1L);
        //    log.info(String.valueOf(myAddresses));
    }

    @Test
    void saveUserAddress() {
        //MallUserAddress mallUserAddress = MallUserAddress.builder()
        //        .userId(1L)
        //        .provinceName("江苏省")
        //        .cityName("南京市")
        //        .regionName("栖霞区")
        //        .detailAddress("羊山北路1号")
        //        .userName("taoranran")
        //        .userPhone("13951905171")
        //        .defaultFlag((byte) 0)
        //        .isDeleted((byte) 0)
        //        .createTime(new Date())
        //        .updateTime(new Date())
        //        .build();
        //Boolean flag = mallUserAddressService.saveUserAddress(mallUserAddress);
        //assertEquals(true, flag);
    }

    @Test
    void updateMallUserAddress() {
        //MallUserAddress mallUserAddress = MallUserAddress.builder()
        //        .addressId(1385789992713883649L)
        //        .userId(1L)
        //        .userName("test")
        //        .userPhone("13322221111")
        //        .defaultFlag((byte) 0)
        //        .updateTime(new Date())
        //        .build();
        //Boolean flag = mallUserAddressService.updateMallUserAddress(mallUserAddress);
        //log.info(String.valueOf(flag));
        //assertTrue(flag);
    }

    @Test
    void getMallUserAddressById() {
        //MallUserAddress address = mallUserAddressService.getMallUserAddressById(1L);
        //log.info(String.valueOf(address));
    }

    @Test
    void getMyDefaultAddressByUserId() {
        //MallUserAddress defaultAddress = mallUserAddressService.getMyDefaultAddressByUserId(1L);
        //log.info(String.valueOf(defaultAddress));
    }

    @Test
    void deleteById() {
        //Boolean flag = mallUserAddressService.deleteById(1385789992713883649L);
        //log.info(String.valueOf(flag));
    }
}