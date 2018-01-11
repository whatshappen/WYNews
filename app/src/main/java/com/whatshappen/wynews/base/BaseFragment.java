package com.whatshappen.wynews.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description Fragment（碎片）的基类
 */
public abstract class BaseFragment extends Fragment {

    protected FragmentActivity activity;
    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        initData(savedInstanceState);
    }

    /**
     * 初始化布局，需子类实现
     *
     * @param inflater
     * @return
     */
    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 空实现，子类重写
     *
     * @param savedInstanceState
     */
    protected void initData(Bundle savedInstanceState) {

    }

    /**
     * 填充fragment
     *
     * @param viewId
     * @param fragment
     * @param tag
     */
    protected FragmentTransaction replaceFragment(int viewId, Fragment fragment, String tag) {
        //获取FragmentManager，并开启事务
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(viewId, fragment, tag);
        //提交
        fragmentTransaction.commit();
        return fragmentTransaction;
    }

    protected FragmentTransaction replaceFragment(int viewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(viewId, fragment);
        fragmentTransaction.commit();
        return fragmentTransaction;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != bind)
            bind.unbind();
    }
}
