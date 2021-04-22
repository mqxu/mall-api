package com.mqxu.mall.api.controller;

import com.mqxu.mall.api.common.ServiceResultEnum;
import com.mqxu.mall.api.config.annotation.TokenToMallUser;
import com.mqxu.mall.api.controller.param.SaveMallUserAddressParam;
import com.mqxu.mall.api.controller.param.UpdateMallUserAddressParam;
import com.mqxu.mall.api.controller.vo.MallUserAddressVO;
import com.mqxu.mall.api.entity.MallUser;
import com.mqxu.mall.api.entity.MallUserAddress;
import com.mqxu.mall.api.service.MallUserAddressService;
import com.mqxu.mall.api.util.BaseBeanUtil;
import com.mqxu.mall.api.util.Result;
import com.mqxu.mall.api.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 用户地址接口
 * @author: mqxu
 * @since: 2021-04-22
 **/
@RestController
@Api(value = "v1", tags = "2.楼楼商城个人地址相关接口")
@RequestMapping("/api/v1")
public class MallUserAddressController {
    @Resource
    private MallUserAddressService mallUserAddressService;

    @GetMapping("/address")
    @ApiOperation(value = "我的收货地址列表", notes = "我的收货地址列表")
    public Result addressList(@TokenToMallUser MallUser loginMallUser) {
        return ResultGenerator.genSuccessResult(mallUserAddressService.getMyAddresses(loginMallUser.getUserId()));
    }

    @PostMapping("/address")
    @ApiOperation(value = "添加收货地址", notes = "添加收货地址")
    public Result saveUserAddress(@RequestBody SaveMallUserAddressParam saveMallUserAddressParam,
                                  @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress userAddress = new MallUserAddress();
        BaseBeanUtil.copyProperties(saveMallUserAddressParam, userAddress);
        userAddress.setUserId(loginMallUser.getUserId());
        Boolean saveResult = mallUserAddressService.saveUserAddress(userAddress);
        //添加成功
        if (saveResult) {
            return ResultGenerator.genSuccessResult();
        }
        //添加失败
        return ResultGenerator.genFailResult("添加失败");
    }

    @PutMapping("/address")
    @ApiOperation(value = "修改收货地址", notes = "修改收货地址")
    public Result updateMallUserAddress(@RequestBody UpdateMallUserAddressParam updateMallUserAddressParam,
                                        @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(updateMallUserAddressParam.getAddressId());
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDDEN_ERROR.getResult());
        }
        MallUserAddress userAddress = new MallUserAddress();
        BaseBeanUtil.copyProperties(updateMallUserAddressParam, userAddress);
        userAddress.setUserId(loginMallUser.getUserId());
        Boolean updateResult = mallUserAddressService.updateMallUserAddress(userAddress);
        //修改成功
        if (updateResult) {
            return ResultGenerator.genSuccessResult();
        }
        //修改失败
        return ResultGenerator.genFailResult("修改失败");
    }

    @GetMapping("/address/{addressId}")
    @ApiOperation(value = "获取收货地址详情", notes = "传参为地址id")
    public Result getMallUserAddress(@PathVariable("addressId") Long addressId,
                                     @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(addressId);
        MallUserAddressVO louMallUserAddressVO = new MallUserAddressVO();
        BaseBeanUtil.copyProperties(mallUserAddressById, louMallUserAddressVO);
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDDEN_ERROR.getResult());
        }
        return ResultGenerator.genSuccessResult(louMallUserAddressVO);
    }

    @GetMapping("/address/default")
    @ApiOperation(value = "获取默认收货地址", notes = "无传参")
    public Result getDefaultMallUserAddress(@TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMyDefaultAddressByUserId(loginMallUser.getUserId());
        return ResultGenerator.genSuccessResult(mallUserAddressById);
    }

    @DeleteMapping("/address/{addressId}")
    @ApiOperation(value = "删除收货地址", notes = "传参为地址id")
    public Result deleteAddress(@PathVariable("addressId") Long addressId,
                                @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(addressId);
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDDEN_ERROR.getResult());
        }
        Boolean deleteResult = mallUserAddressService.deleteById(addressId);
        //删除成功
        if (deleteResult) {
            return ResultGenerator.genSuccessResult();
        }
        //删除失败
        return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
    }
}
