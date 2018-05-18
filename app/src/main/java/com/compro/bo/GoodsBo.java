package com.compro.bo;

import com.compro.httphelp.NewResultCallBack;
import com.konggeek.android.geek.http.GeekHttp;
import com.konggeek.android.geek.http.HttpParams;


/**
 * Created by Lenovo on 2018/5/16.
 */

public class GoodsBo {
    /**
     * 黄金价格波动集合
     *
     * @param resultCallBack
     */
    public static void goodsGoldPriceList(NewResultCallBack resultCallBack) {
        HttpParams params = new HttpParams();
        GeekHttp.getHttp().post(1, Url.GOODS_GOLD_PRICE_LIST, params, resultCallBack);
    }

}
