package com.konggeek.android.geek.http;

import com.konggeek.android.geek.utils.PrintUtil;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.OnResponseListener;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.RequestQueue;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.download.DownloadRequest;

/**
 * 提供访问网络快捷功能
 * Created by wanglei on 16/3/28.
 */
public class GeekHttp {

    public static final String TAG = "GeekHttp";

    private static GeekHttp geekHttp;
    private RequestQueue queue;


    public static GeekHttp getHttp() {
        if (geekHttp == null) {
            synchronized (GeekHttp.class) {
                if (geekHttp == null) {
                    geekHttp = new GeekHttp();
                }
            }
        }
        return geekHttp;
    }

    public GeekHttp() {
        this.queue = NoHttp.newRequestQueue();
    }

    /**
     * GET请求
     * @param what
     * @param URL
     * @param responseListener
     */
    public void get(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" GET", URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        queue.add(what, request, responseListener);
    }

    /**
     * GET请求
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void get(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" GET", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.GET);
        params.handle(request);
        queue.add(what, request, responseListener);
    }


    /**
     * POST请求
     * @param what
     * @param URL
     * @param responseListener
     */
    public void post(int what, String URL, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" POST", URL);
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        queue.add(what, request, responseListener);
    }

    /**
     * POST请求
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void post(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" POST", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        params.handle(request);
        queue.add(what, request, responseListener);
    }

    /**
     * POST请求(类型为：application/x-www-form-urlencoded)
     * @param what
     * @param URL
     * @param params
     * @param responseListener
     */
    public void postType(int what, String URL, HttpParams params, OnResponseListener responseListener) {
        PrintUtil.log(TAG+" POST", URL + "?" + params.toString());
        Request<String> request = NoHttp.createStringRequest(URL, RequestMethod.POST);
        request.setHeader("Content-Type","application/x-www-form-urlencoded");
        params.handle(request);
        queue.add(what, request, responseListener);
    }

    /**下载
     @param URL 下载地址
     @param fileFolder 文件保存到手机的路径
     @param filename 文件保存的名称
     @param l           */
    public static void downFile(String URL, String fileFolder, String filename, DownloadListener l) {

        DownloadQueue downloadQueue = NoHttp.newDownloadQueue();
        DownloadRequest downloadRequest = NoHttp.createDownloadRequest(URL, fileFolder, filename, true, true);
        downloadQueue.add(0, downloadRequest, l);
    }

    /**
     * 获取请求队列
     * @return
     */
    public RequestQueue getQueue() {
        return queue;
    }

}
