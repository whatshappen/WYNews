package com.whatshappen.wynews.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description 自定义AnimationDrawable，添加帧动画结束的监听
 */
public abstract class CustomAnimationDrawable extends AnimationDrawable {

    public CustomAnimationDrawable(AnimationDrawable animationDrawable){
        for (int i=0;i<animationDrawable.getNumberOfFrames();i++){
            this.addFrame(animationDrawable.getFrame(i),animationDrawable.getDuration(i));
        }
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            onAnimationFinished();
        }
    };

    @Override
    public void start() {
        super.start();
        //发送延迟消息，动画结束时，调用
        handler.postDelayed(runnable, getTotalDuration());
    }

    /**
     * 计算帧动画的总时间
     *
     * @return
     */
    private long getTotalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < getNumberOfFrames(); i++) {
            totalDuration += getDuration(i);
        }
        return totalDuration;
    }

    /**
     * 动画结束时监听
     */
    public abstract void onAnimationFinished();


}
