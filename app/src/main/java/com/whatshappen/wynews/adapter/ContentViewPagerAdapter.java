package com.whatshappen.wynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.whatshappen.wynews.base.BaseFragment;

import java.util.ArrayList;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description 主界面ViewPager适配器
 */
public class ContentViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<BaseFragment> baseFragments;

    public ContentViewPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> baseFragments) {
        super(fm);
        this.baseFragments = baseFragments;
    }

    @Override
    public int getCount() {
        return baseFragments==null?0:baseFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragments.get(position);
    }
}
