package com.konggeek.android.geek.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * json数据解析工具
 *
 * @author wanglei
 */
public class JSONUtil {

    /**
     * 使用JSON工具把数据转换成json对象
     *
     * @param value 是对解析的集合的类型
     */
    public static String toString(Object value) {
        String str = JSON.toJSONString(value);
        return str;
    }

    /**
     * 对单个javabean进行解析
     *
     * @param <T>
     * @param json 要解析的json字符串
     * @param cls
     * @return
     */
    public static <T> T getObj(String json, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 对list类型进行解析
     *
     * @param <T>
     * @param json 要解析的json字符串
     * @param cls
     * @return
     */
    public static <T> List<T> getListObj(String json, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        if (!TextUtils.isEmpty(json)) {
            try {
                list = JSON.parseArray(json, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 对MapString类型数据进行解析
     *
     * @param json
     * @return
     */
    public static Map<String, String> getMapStr(String json) {
        Map<String, String> mapStr = null;
        if (!TextUtils.isEmpty(json)) {
            try {
                mapStr = JSON.parseObject(json, new TypeReference<Map<String, String>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapStr;
    }

    public static List<String> getStringList(String json) {
        List<String> stringList = new ArrayList<>();
        if (!TextUtils.isEmpty(json)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    stringList.add(jsonArray.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
