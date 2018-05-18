package com.compro.bo;

/**
 * Created by Lenovo on 2018/5/17.
 */

public class Url {
    //测试
    private static final String TEST =  "http://192.168.1.53:8082/investapp/api";
    //线上
    private static final String ONLINE = "http://api.saintleon.net";
    //host
    public static final String HOST = ONLINE;
//    public static final String HOST = TEST;

    /**
     * Goods
     */
    //黄金价格波动集合
    public static final String GOODS_GOLD_PRICE_LIST = HOST + "/goods/goldPriceList.htm";
}
