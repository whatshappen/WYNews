package com.whatshappen.wynews.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whatshappen.wynews.R;
import com.whatshappen.wynews.base.BaseFragment;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description 要闻
 */
public class NewsFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,null);
    }
}
