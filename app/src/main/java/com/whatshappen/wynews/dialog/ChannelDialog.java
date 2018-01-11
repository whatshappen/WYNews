package com.whatshappen.wynews.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.whatshappen.wynews.R;
import com.whatshappen.wynews.utils.UIUitls;


/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/11 ;
 * @Description 频道选择对话框
 */
public class ChannelDialog extends AlertDialog {

    private Context context;

    public ChannelDialog(@NonNull Context context) {
        this(context, 0);
        this.context = context;
    }

    public ChannelDialog(@NonNull Context context, int themeResId) {
        super(context, R.style.channel_dialog_style);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置点击对话框之外的位置，对话框不消失
        this.setCanceledOnTouchOutside(false);
        //设置宽高属性
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        //减去状态栏的高度
        int distance = (int) (UIUitls.getDimension(context, R.dimen.tool_bar_height)
                +UIUitls.getDimension(context, R.dimen.home_tab_height))
                +UIUitls.getStatusBarHeight(context);
        window.setGravity(Gravity.LEFT | Gravity.TOP); // 此处可以设置dialog显示的位置
        attributes.width = UIUitls.getScreenWidth(context);
        attributes.height = UIUitls.getScreenHeight(context) - distance;
//        attributes.height = 100;
        attributes.y = distance;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.channel_dialog_anim);
        setContentView(R.layout.dialog_channel);
    }
}