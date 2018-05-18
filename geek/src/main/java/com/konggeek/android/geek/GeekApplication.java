package com.konggeek.android.geek;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.yolanda.nohttp.NoHttp;

public class GeekApplication extends Application {

    private static Context context;
    private static String packageName;

    /**
     * 每次app开启会调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        packageName = getPackageName();
        NoHttp.init(this);
        initImageLoader(context);
    }

    /**
     * 全局上下文对象
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 项目包名
     */
    public static String getPackage() {
        return packageName;
    }

    /**
     * 初始化图片缓存
     * @param context
     */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        ImageLoader.getInstance().init(config.build());
    }

}
