package com.mqxu.mall.api.common;

/**
 * @description: 业务结果枚举
 * @author: mqxu
 * @since: 2021-04-20
 **/
public enum ServiceResultEnum {
    /**
     * error
     */
    ERROR("error"),
    /**
     * success
     */
    SUCCESS("success"),
    /**
     * 未查询到记录
     */
    DATA_NOT_EXIST("未查询到记录！"),
    /**
     * 未查询到记录
     */
    PARAM_ERROR("未查询到记录！"),
    /**
     * 有同级同名的分类
     */
    SAME_CATEGORY_EXIST("有同级同名的分类！"),
    /**
     * 用户名已存在
     */
    SAME_LOGIN_NAME_EXIST("用户名已存在！"),
    /**
     * 请输入登录名
     */
    LOGIN_NAME_NULL("请输入登录名！"),
    /**
     * 请输入正确的手机号
     */
    LOGIN_NAME_IS_NOT_PHONE("请输入正确的手机号！"),
    /**
     * 请输入密码
     */
    LOGIN_PASSWORD_NULL("请输入密码！"),
    /**
     * 请输入验证码
     */
    LOGIN_VERIFY_CODE_NULL("请输入验证码！"),
    /**
     * 验证码错误
     */
    LOGIN_VERIFY_CODE_ERROR("验证码错误！"),
    /**
     * 商品不存在
     */
    GOODS_NOT_EXIST("商品不存在！"),
    /**
     * 商品已下架
     */
    GOODS_PUT_DOWN("商品已下架！"),
    /**
     * 超出单个商品的最大购买数量
     */
    SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR("超出单个商品的最大购买数量！"),
    /**
     * 商品数量不能小于 1
     */
    SHOPPING_CART_ITEM_NUMBER_ERROR("商品数量不能小于 1 ！"),
    /**
     * 超出购物车最大容量
     */
    SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR("超出购物车最大容量！"),
    /**
     * 已存在！无需重复添加
     */
    SHOPPING_CART_ITEM_EXIST_ERROR("已存在！无需重复添加！"),
    /**
     * 登录失败
     */
    LOGIN_ERROR("登录失败！"),
    /**
     * 未登录
     */
    NOT_LOGIN_ERROR("未登录！"),
    /**
     * 无效认证！请重新登录
     */
    TOKEN_EXPIRE_ERROR("无效认证！请重新登录！"),
    /**
     * 无效用户！请重新登录
     */
    USER_NULL_ERROR("无效用户！请重新登录！"),
    /**
     * 用户已被禁止登录
     */
    LOGIN_USER_LOCKED_ERROR("用户已被禁止登录！"),
    /**
     * 订单不存在
     */
    ORDER_NOT_EXIST_ERROR("订单不存在！"),
    /**
     * 地址不能为空
     */
    NULL_ADDRESS_ERROR("地址不能为空！"),
    /**
     * 订单价格异常
     */
    ORDER_PRICE_ERROR("订单价格异常！"),
    /**
     * 订单项异常
     */
    ORDER_ITEM_NULL_ERROR("订单项异常！"),
    /**
     * 生成订单异常
     */
    ORDER_GENERATE_ERROR("生成订单异常！"),
    /**
     * 购物车数据异常
     */
    SHOPPING_ITEM_ERROR("购物车数据异常！"),
    /**
     * 库存不足
     */
    SHOPPING_ITEM_COUNT_ERROR("库存不足！"),
    /**
     * 订单状态异常
     */
    ORDER_STATUS_ERROR("订单状态异常！"),
    /**
     * 操作失败
     */
    OPERATE_ERROR("操作失败！"),
    /**
     * 禁止该操作
     */
    REQUEST_FORBIDDEN_ERROR("禁止该操作！"),
    /**
     * database error
     */
    DB_ERROR("database error");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
