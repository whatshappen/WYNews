package com.whatshappen.wynews.ui;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.whatshappen.wynews.R;
import com.whatshappen.wynews.adapter.ContentViewPagerAdapter;
import com.whatshappen.wynews.base.BaseActivity;
import com.whatshappen.wynews.base.BaseFragment;
import com.whatshappen.wynews.ui.fragment.HomeFragment;
import com.whatshappen.wynews.ui.fragment.LiveFragment;
import com.whatshappen.wynews.ui.fragment.NewsFragment;
import com.whatshappen.wynews.ui.fragment.UserFragment;
import com.whatshappen.wynews.ui.fragment.VideoFragment;
import com.whatshappen.wynews.ui.fragment.utils.FragmentFactory;
import com.whatshappen.wynews.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.view_pager)
    public NoScrollViewPager viewPager;
    @BindView(R.id.radio_group)
    public RadioGroup radioGroup;
    private ArrayList<BaseFragment> baseFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        baseFragments = new ArrayList<>();
        baseFragments.add(FragmentFactory.creat(HomeFragment.class));
        baseFragments.add(FragmentFactory.creat(NewsFragment.class));
        baseFragments.add(FragmentFactory.creat(LiveFragment.class));
        baseFragments.add(FragmentFactory.creat(VideoFragment.class));
        baseFragments.add(FragmentFactory.creat(UserFragment.class));
        //设置适配器
        ContentViewPagerAdapter pagerAdapter = new ContentViewPagerAdapter(getSupportFragmentManager(), baseFragments);
        viewPager.setAdapter(pagerAdapter);
        //设置ViewPager改变监听
        viewPager.setOnPageChangeListener(this);
        //设置选择改变监听
        radioGroup.setOnCheckedChangeListener(this);
        //设置默认第0页选中
        radioGroup.check(R.id.rbt_home);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbt_home:
                viewPager.setCurrentItem(0,false);//无滑动动画
                break;
            case R.id.rbt_news:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.rbt_live:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.rbt_video:
                viewPager.setCurrentItem(3,false);
                break;
            case R.id.rbt_user:
                viewPager.setCurrentItem(4,false);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        HomeFragment homeFragment = (HomeFragment) baseFragments.get(0);
        if(position==0){
            homeFragment.onVisible();
        }else {
            homeFragment.onInVisible();
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
