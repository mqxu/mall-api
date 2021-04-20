package com.mqxu.mall.api.common;

/**
 * @description: 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
 * @author: mqxu
 * @since: 2021-04-20
 **/
public enum MallOrderStatusEnum {
    /**
     * 默认值
     */
    DEFAULT(-9, "ERROR"),
    /**
     * 待支付
     */
    ORDER_PRE_PAY(0, "待支付"),
    /**
     * 已支付
     */
    ORDER_PAID(1, "已支付"),
    /**
     * 配货完成
     */
    ORDER_PACKAGED(2, "配货完成"),
    /**
     * 出库成功
     */
    ORDER_EXPRESS(3, "出库成功"),
    /**
     * 交易成功
     */
    ORDER_SUCCESS(4, "交易成功"),
    /**
     * 手动关闭
     */
    ORDER_CLOSED_BY_USER(-1, "手动关闭"),
    /**
     * 超时关闭
     */
    ORDER_CLOSED_BY_EXPIRED(-2, "超时关闭"),
    /**
     * 商家关闭
     */
    ORDER_CLOSED_BY_BUSINESS(-3, "商家关闭");

    private int orderStatus;

    private String name;

    MallOrderStatusEnum(int orderStatus, String name) {
        this.orderStatus = orderStatus;
        this.name = name;
    }

    public static MallOrderStatusEnum getMallOrderStatusEnumByStatus(int orderStatus) {
        for (MallOrderStatusEnum mallOrderStatusEnum : MallOrderStatusEnum.values()) {
            if (mallOrderStatusEnum.getOrderStatus() == orderStatus) {
                return mallOrderStatusEnum;
            }
        }
        return DEFAULT;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
