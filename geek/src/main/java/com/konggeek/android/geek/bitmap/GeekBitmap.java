package com.konggeek.android.geek.bitmap;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.konggeek.android.geek.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 提供图片相关处理
 * Created by wanglei on 16/3/28.
 */
public class GeekBitmap {
    public static final int KEY = -1;
    private static DisplayImageOptions options;

    public static void display(ImageView imageView, String uri) {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.ic_pic_loding)// 设置图片下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.ic_pic_loding)// 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.ic_pic_loding)// 设置图片加载或解码过程中发生错误显示的图片
                    .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                    .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .build();
        }
        if (!uri.equals(imageView.getTag(KEY))) {
            ImageLoader.getInstance().displayImage(uri, imageView, options);
            imageView.setTag(KEY, uri);
        }
    }


    public static void display(ImageView imageView, String uri, int loadingRes, int emptyUriRes, int failRes) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(loadingRes)// 设置图片下载期间显示的图片
                .showImageForEmptyUri(emptyUriRes)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(failRes)// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .build();
        if (!uri.equals(imageView.getTag(KEY))) {
            ImageLoader.getInstance().displayImage(uri, imageView, options);
            imageView.setTag(KEY, uri);
        }
    }

    /**
     * 显示圆角的图片 （包括默认图和错误图）
     * @param imageView
     * @param cornerRadiusPixels
     * @param uri
     * @param loadingRes
     * @param emptyUriRes
     * @param failRes
     */
    public static void display(ImageView imageView,int cornerRadiusPixels, String uri, int loadingRes, int emptyUriRes, int failRes) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(loadingRes)// 设置图片下载期间显示的图片
                .showImageForEmptyUri(emptyUriRes)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(failRes)// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels))
                .build();
        if (!uri.equals(imageView.getTag(KEY))) {
            ImageLoader.getInstance().displayImage(uri, imageView, options);
            imageView.setTag(KEY, uri);
        }
    }

    /**
     * 显示圆角的图片 (图片加载成功回调)
     * @param imageView
     * @param cornerRadiusPixels
     * @param uri
     */
    public static void display(ImageView imageView, int cornerRadiusPixels, String uri, int loadingRes, int emptyUriRes, int failRes,ImageLoadingListener loadingListener) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(loadingRes)// 设置图片下载期间显示的图片
                .showImageForEmptyUri(emptyUriRes)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(failRes)// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(false)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels))
                .build();
        if (!uri.equals(imageView.getTag(KEY))) {
            ImageLoader.getInstance().displayImage(uri, imageView, options,loadingListener);
            imageView.setTag(KEY, uri);
        }
    }

    /**
     * 显示圆角的图片
     * @param imageView 显示图片的View
     * @param cornerRadiusPixels 圆角半径像素
     * @param uri 图片的地址
     */
    public static void display(ImageView imageView, int cornerRadiusPixels, String uri) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels))
                .build();
        if (!uri.equals(imageView.getTag(KEY))) {
            ImageLoader.getInstance().displayImage(uri, imageView, options);
            imageView.setTag(KEY, uri);
        }
    }


}
