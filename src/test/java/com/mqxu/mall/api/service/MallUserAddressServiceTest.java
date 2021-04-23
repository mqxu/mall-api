package com.mqxu.mall.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MallUserAddressServiceTest {
    @Resource
    private MallUserAddressService mallUserAddressService;

    @Test
    void getMyAddresses() {

    }

    @Test
    void saveUserAddress() {
        //MallUserAddress mallUserAddress = new MallUserAddress();
        //mallUserAddress.setUserId(1L);
        //mallUserAddress.setProvinceName("江苏省");
        //mallUserAddress.setCityName("南京市");
        //mallUserAddress.setRegionName("栖霞区");
        //mallUserAddress.setDetailAddress("羊山北路1号");
        //mallUserAddress.setUserName("陶然然");
        //mallUserAddress.setUserPhone("13951905171");
        //mallUserAddress.setIsDeleted((byte) 0);
        //mallUserAddress.setDefaultFlag((byte) 1);
        //mallUserAddress.setCreateTime(new Date());
        //mallUserAddress.setUpdateTime(new Date());
        //Boolean flag = mallUserAddressService.saveUserAddress(mallUserAddress);
        //assertEquals(true, flag);
    }

    @Test
    void updateMallUserAddress() {
    }

    @Test
    void getMallUserAddressById() {
        //MallUserAddress address = mallUserAddressService.getMallUserAddressById(3L);
        //System.out.println(address);
    }

    @Test
    void getMyDefaultAddressByUserId() {
        //MallUserAddress defaultAddress = mallUserAddressService.getMyDefaultAddressByUserId(1L);
        //System.out.println(defaultAddress);

    }

    @Test
    void deleteById() {
    }
}