package com.whatshappen.wynews.ui.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.whatshappen.wynews.R;
import com.whatshappen.wynews.base.BaseFragment;
import com.whatshappen.wynews.dialog.ChannelDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/11 ;
 * @Description
 */
public class HomeNewsFragment extends BaseFragment {

    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTabLayout;//tab
    @BindView(R.id.ll_tab_more)
    LinearLayout linearLayoutMore;//修改栏目
    @BindView(R.id.iv_tab_more_icon)
    ImageView ivMore;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_news,container,false);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        System.out.println("----------0 ="+viewPager.getMeasuredHeight());
    }

    @OnClick(R.id.ll_tab_more)
    void click(View v){
        if(v.getId()==R.id.ll_tab_more){
            ivMore.setBackgroundDrawable(getResources().getDrawable(R.mipmap.icon_home_tab_ag0));
            ChannelDialog channelDialog = new ChannelDialog(activity);
            channelDialog.show();
        }
    }
}
