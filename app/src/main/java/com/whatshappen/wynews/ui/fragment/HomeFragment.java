package com.whatshappen.wynews.ui.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.whatshappen.wynews.R;
import com.whatshappen.wynews.base.BaseFragment;
import com.whatshappen.wynews.widget.CustomAnimationDrawable;

import butterknife.BindView;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description 首页
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.ib_search)
    public ImageButton imgBtnSearch;//搜索
    @BindView(R.id.ib_live)
    public ImageView imgBtnLive;//直播
    @BindView(R.id.fl_content)
    public FrameLayout flContent;//主内容
    private static Handler handler = new Handler();
    private CustomAnimationDrawable animationDrawable;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        //设置帧动画
        animationDrawable = new CustomAnimationDrawable((AnimationDrawable) imgBtnLive.getBackground()) {
            @Override
            public void onAnimationFinished() {
                stop();
            }
        };
        imgBtnLive.setBackgroundDrawable(animationDrawable);
        startAnimation();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != animationDrawable) {
            if (animationDrawable.isRunning())
                animationDrawable.stop();
            animationDrawable.setCallback(null);
            animationDrawable = null;
        }
    }

    //可见
    public void onVisible() {
        startAnimation();
    }

    //不可见
    public void onInVisible() {
        if (null != animationDrawable && animationDrawable.isRunning())
            animationDrawable.stop();
    }

    private void startAnimation() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
                // }
            }
        }, 50);
    }
}
