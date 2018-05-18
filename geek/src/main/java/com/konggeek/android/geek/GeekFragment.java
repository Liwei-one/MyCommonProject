package com.konggeek.android.geek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konggeek.android.geek.view.InjectedView;

/**
 * 基础的Fragment
 * 提供Fragment快捷功能
 * Created by wanglei on 16/3/25.
 */

public class GeekFragment extends Fragment {

    public GeekFragmentActivity mActivity;
    public LayoutInflater mInflater;
    public FragmentManager mFManager;
    public Bundle mBundle;
    public Fragment mFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = (GeekFragmentActivity) getActivity();
        this.mFManager = mActivity.mFManager;
        this.mBundle = getArguments();
        this.mFragment = this;
    }

    public View setContentView(LayoutInflater inflater, int layoutResID, ViewGroup container) {
        return setContentView(inflater, layoutResID, container, false);
    }

    public View setContentView(LayoutInflater inflater, int layoutResID, ViewGroup container, boolean attachToRoot) {
        this.mInflater = inflater;
        View viewRoot = inflater.inflate(layoutResID, container, attachToRoot);
        InjectedView.init(this, viewRoot);
        viewRoot.setOnClickListener(null);
        return viewRoot;
    }
}
