package com.lanky.androidutils;

import android.view.View;

import androidx.core.view.ViewCompat;

/**
 * @ClassName UiUtils
 * @Description TODO
 * @Author LankyBin
 * @Date 2021/6/24 14:09
 * @Version 1.0
 */
public class UiUtils {

    /**
     * View选中动效
     * @param v - View
     * @param hasFocus - 是否被选中
     * @param mWProportion - 横向放大倍数（一般1.00-1.50）
     * @param mHProportion - 纵向放大倍数（一般1.00-1.50）
     */
    public static void animateView(View v, boolean hasFocus, float mWProportion, float mHProportion){
        if (hasFocus) {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(mWProportion)
                    .scaleY(mHProportion)
                    .start();
        } else {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1f)
                    .scaleY(1f)
                    .start();
        }
    }
}
