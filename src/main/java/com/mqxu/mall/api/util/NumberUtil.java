package com.mqxu.mall.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mqxu
 * @description: 数字工具
 */
public class NumberUtil {

    private NumberUtil() {
    }

    /**
     * 判断是否为11位电话号码
     *
     * @param phone 电话号码
     * @return boolean
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 生成指定长度的随机数
     *
     * @param length 长度
     * @return int
     */
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 生成订单流水号
     *
     * @return 订单流水号
     */
    public static String genOrderNo() {
        StringBuilder strBuilder = new StringBuilder(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        strBuilder.append(num);
        return strBuilder.toString();
    }
}
