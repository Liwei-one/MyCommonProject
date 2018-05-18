package com.konggeek.android.geek.http;

import android.text.TextUtils;

import com.konggeek.android.geek.utils.JSONUtil;
import com.konggeek.android.geek.utils.PrintUtil;
import com.yolanda.nohttp.OnResponseListener;
import com.yolanda.nohttp.Response;

/**
 * 提供请求结果快捷功能
 * Created by wanglei on 16/3/29.
 */
public abstract class ResultCallBack implements OnResponseListener<String> {

    @Override
    public void onStart(int what) {
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String resultStr = response.get();
        PrintUtil.log(GeekHttp.TAG, "onSucceed:" + what + "\n" + resultStr);
        Result result = null;
        if (!TextUtils.isEmpty(resultStr)) {
            result = JSONUtil.getObj(resultStr, Result.class);
        }
        if (result == null) {
            result = new Result();
            result.setRetCode(RetCode.WRONG_DATA);
            result.setErrorMsg("数据异常");
        } else {
            result.setJson(resultStr);
        }
        onSuccess(what, result);

    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        PrintUtil.log(GeekHttp.TAG, "onFailed:" + what + "\nurl:" + url + "\ntag:" + tag + "\nexception:" + exception.getLocalizedMessage() + "\nresponseCode:" + responseCode + "\nnetworkMillis:" + networkMillis);
        Result result = new Result();
        result.setRetCode("E"+responseCode);
        result.setErrorMsg("网络异常");
        onSuccess(what,result);
    }

    @Override
    public void onFinish(int what) {
    }

    public abstract void onSuccess(int what, Result result);

}
