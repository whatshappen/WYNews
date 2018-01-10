package com.whatshappen.wynews;

import android.view.View;

import com.whatshappen.wynews.base.APPActivity;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description
 */
public class DemoActivity extends APPActivity {

    @Override
    protected View setContentViewId() {
        return View.inflate(this,R.layout.layout,null);
    }
}
