package com.konggeek.android.geek;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.konggeek.android.geek.manager.ActivityManager;
import com.konggeek.android.geek.view.InjectedView;

/**
 * APP基础Activity
 * 提供Activity快捷功能
 * Created by wanglei on 16/3/23.
 */

public class GeekActivity extends AppCompatActivity {

    public GeekActivity mActivity;
    public LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivity().add(this);
        mActivity = this;
        mInflater = LayoutInflater.from(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        InjectedView.init(this);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getActivity().remove(this);
        super.onDestroy();
    }

}
