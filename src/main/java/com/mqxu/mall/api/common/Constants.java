package com.mqxu.mall.api.common;

/**
 * @description: 常量类
 * @author: mqxu
 * @since: 2021-04-20
 **/
public class Constants {
    /**
     * 上传文件的默认url前缀，根据自己情况修改，
     * 这里是mac和linux写法，切记upload后面要加 /
     * windows写法为："D:\\upload\\"
     */
    //public final static String FILE_UPLOAD_DIC = "/Users/mqxu/upload/";
    public final static String FILE_UPLOAD_DIC = "/root/upload/";

    /**
     * 首页轮播图数量(可根据自身需求修改)
     */
    public final static int INDEX_CAROUSEL_NUMBER = 5;

    /**
     * 首页一级分类的最大数量
     */
    public final static int INDEX_CATEGORY_NUMBER = 10;

    /**
     * 搜索页一级分类的最大数量
     */
    public final static int SEARCH_CATEGORY_NUMBER = 8;

    /**
     * 首页热卖商品数量
     */
    public final static int INDEX_GOODS_HOT_NUMBER = 4;

    /**
     * 首页新品数量
     */
    public final static int INDEX_GOODS_NEW_NUMBER = 5;

    /**
     * 首页推荐商品数量
     */
    public final static int INDEX_GOODS_RECOMMOND_NUMBER = 10;

    /**
     * 购物车中商品的最大数量(可根据自身需求修改)
     */
    public final static int SHOPPING_CART_ITEM_TOTAL_NUMBER = 20;

    /**
     * 购物车中单个商品的最大购买数量(可根据自身需求修改)
     */
    public final static int SHOPPING_CART_ITEM_LIMIT_NUMBER = 5;

    /**
     * 搜索分页的默认条数(每页10条)
     */
    public final static int GOODS_SEARCH_PAGE_LIMIT = 10;

    /**
     * 购物车分页的默认条数(每页5条)
     */
    public final static int SHOPPING_CART_PAGE_LIMIT = 5;

    /**
     * 购物车分页的默认条数(每页10条)
     */
    public final static int USER_ADDRESS_PAGE_LIMIT = 10;

    /**
     * 我的订单列表分页的默认条数(每页5条)
     */
    public final static int ORDER_SEARCH_PAGE_LIMIT = 5;

    /**
     * 商品上架状态
     */
    public final static int SELL_STATUS_UP = 0;

    /**
     * 商品下架状态
     */
    public final static int SELL_STATUS_DOWN = 1;

    /**
     * token字段长度
     */
    public final static int TOKEN_LENGTH = 32;

    /**
     * 个人信息默认简介
     */
    public final static String USER_INTRO = "随心所欲，丰富多彩";


    /**
     * API登录接口端点
     */
    public final static String API_LOGIN = "/api/v1/user/login";

    /**
     * API注册接口端点
     */
    public final static String API_REGISTER = "/api/v1/user/register";

    /**
     * API首页接口端点
     */
    public final static String API_INDEX = "/api/v1/index-infos";


}
