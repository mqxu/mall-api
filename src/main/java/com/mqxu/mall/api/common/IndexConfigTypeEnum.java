package com.mqxu.mall.api.common;


/**
 * @description: 首页配置项枚举 1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐
 * @author: mqxu
 * @since: 2021-04-20
 **/
public enum IndexConfigTypeEnum {
    /**
     * 默认值
     */
    DEFAULT(0, "DEFAULT"),
    /**
     * 搜索框热搜
     */
    INDEX_SEARCH_HOTS(1, "INDEX_SEARCH_HOTS"),
    /**
     * 搜索下拉框热搜
     */
    INDEX_SEARCH_DOWN_HOTS(2, "INDEX_SEARCH_DOWN_HOTS"),
    /**
     * (首页)热销商品
     */
    INDEX_GOODS_HOT(3, "INDEX_GOODS_HOTS"),
    /**
     * (首页)新品上线
     */
    INDEX_GOODS_NEW(4, "INDEX_GOODS_NEW"),
    /**
     * (首页)为你推荐
     */
    INDEX_GOODS_RECOMMEND(5, "INDEX_GOODS_RECOMMEND");

    private int type;

    private String name;

    IndexConfigTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static IndexConfigTypeEnum getIndexConfigTypeEnumByType(int type) {
        for (IndexConfigTypeEnum indexConfigTypeEnum : IndexConfigTypeEnum.values()) {
            if (indexConfigTypeEnum.getType() == type) {
                return indexConfigTypeEnum;
            }
        }
        return DEFAULT;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
