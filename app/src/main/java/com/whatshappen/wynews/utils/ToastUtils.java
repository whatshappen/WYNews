package com.whatshappen.wynews.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description Toast工具类
 */
public class ToastUtils {

    private static Toast toast = null;

    /**
     * showToast --> String
     *
     * @param context
     * @param desc
     * @param flag    0:LENGTH_SHORT;other:LENGTH_LONG
     */
    public static void showToast(Context context, String desc, int flag) {
        if (null == context || null == desc)
            return;
        if (null == toast)
            toast = Toast.makeText(context, desc, flag == 0 ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        else
            toast.setText(desc);
        toast.show();
    }

    /**
     * showToast --> int
     *
     * @param context
     * @param resId
     * @param flag
     */
    public static void showToast(Context context, int resId, int flag) {
        if (null == context)
            return;
        if (null == toast)
            toast = Toast.makeText(context, resId, flag == 0 ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        else
            toast.setText(resId);
        toast.show();
    }
}
